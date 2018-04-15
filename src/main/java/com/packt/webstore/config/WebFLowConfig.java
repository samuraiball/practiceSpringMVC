package com.packt.webstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
public class WebFLowConfig extends AbstractFlowConfiguration {
    @Bean
    public FlowDefinitionRegistry flowRegistry() {

        /**
         * ここで、addFlowLocationPatternの**と*に当てはまる文字列がFlowのIDになる。
         * 特定のFlowを呼び出すときは、http://localhost:8080/IDとなる。
         */
        return getFlowDefinitionRegistryBuilder()
                .setBasePath("/WEB-INF/flows")
                .addFlowLocationPattern("/**/*-flow.xml")
                .build();
    }

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }

    /**
     * dispacherの設定
     *
     */
    @Bean
    public FlowHandlerMapping flowHandlerMapping(){
        FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
        flowHandlerMapping.setOrder(-1);
        flowHandlerMapping.setFlowRegistry(flowRegistry());
        return flowHandlerMapping;
    }

    /**
     * DispatcherサーブレットとWebFlowとの関係を設定
     *
     */
    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdaptor = new FlowHandlerAdapter();
        handlerAdaptor.setFlowExecutor(flowExecutor());
        handlerAdaptor.setSaveOutputToFlashScopeOnRedirect(true);
        return handlerAdaptor;
    }

}
