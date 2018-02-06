package com.packt.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * ログインの設定
 * ログインされていない場合これらの設定に従って動作する。
 * @author hirooka
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //ユーザーの登録
    //ユーザーの権限付与
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("john").password("pa55word").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("USER", "ADMIN");
    }


    /**
     * 認証のさいのいろいろな設定
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        //認証がされていない場合とのページに飛ばすかの設定
        //ユーザーネームとパスワードのパラメーターもここで設定
        httpSecurity.formLogin().loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password");

        httpSecurity.formLogin().defaultSuccessUrl("/market/products/add")
                .failureUrl("/login?error");

        //ログアウトが成功した際のページ呼び出し
        httpSecurity.logout().logoutSuccessUrl("/login?logout");

        //許可されていないページへ入った際に呼び出される。
        httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");

        //ロールによってredirectするページを変更する。
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**/add").access("hasRole('ADMIN')")
                .antMatchers("/**/market/**").access("hasRole('USER')");

        //
        httpSecurity.csrf().disable();
    }
}
