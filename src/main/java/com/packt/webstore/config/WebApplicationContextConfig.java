package com.packt.webstore.config;


import com.packt.webstore.intercepter.ProcessingTimeLogInterceptor;
import com.packt.webstore.intercepter.PromoCodeInterceptor;
import com.packt.webstore.validator.ProductValidator;
import com.packt.webstore.validator.UnitsInStockValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan("com.packt.webstore")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/img/**")
               .addResourceLocations("/resources/images/");
    }


    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("c");
        return resource;
    }


    /**
     *　
     *  @return
     */
    @Bean
    public HandlerInterceptor promoCodeInterceptor(){
        PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
        promoCodeInterceptor.setPromoCode("OFF3R");
        promoCodeInterceptor.setOfferRedirect("/market/products");
        promoCodeInterceptor.setErrorRedirect("invalidPromoCode");
        return promoCodeInterceptor;
    }

    /**
     *　validatorにメッセージソースを渡す。
     *  @return
     */
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    /**
     *
     */
    @Bean
    public ProductValidator productValidator(){
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new UnitsInStockValidator());
        ProductValidator productValidator = new ProductValidator();
        productValidator.setSpringValidator(springValidators);
        return productValidator;
    }

    /**
     * Springにバリデーションがあることを教える。
     * @return
     */
    @Override
    public Validator getValidator(){
        return validator();
    }

    /**
     * HandlerMappingの設定
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    /**
     * インターセプターの設定
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ProcessingTimeLogInterceptor());
        registry.addInterceptor(promoCodeInterceptor())
                .addPathPatterns("/**/market/products/specialOffer");
    }
}