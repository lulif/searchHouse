package com.gdxx.config;

import com.gdxx.security.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gdxx.security.AuthProvider;
import com.gdxx.security.LoginAuthFailHandler;
import com.gdxx.security.LoginUrlEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // http权限控制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
        // 资源访问权限
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll() // 管理员登录入口
                .antMatchers("/static/**").permitAll() // 静态资源
                .antMatchers("/user/login").permitAll() // 用户登录入口
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER").and()
//              .antMatchers("/admin/**").permitAll()
//              .antMatchers("/user/**").permitAll()
//              .antMatchers("/api/user/**").permitAll().and()

                //loginProcessingUrl()提交用户名和密码的URL
                .formLogin().loginProcessingUrl("/login").failureHandler(authFailHandler()).and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/logout/page").deleteCookies("JSESSIONID").invalidateHttpSession(true).and()

                //authenticationEntryPoint()用来解决匿名用户访问无权限资源时的异常
                .exceptionHandling().authenticationEntryPoint(urlEntryPoint()).accessDeniedPage("/403");

        http.csrf().disable();// 防御策略
        http.headers().frameOptions().sameOrigin();// 开启同源策略
    }

    @Autowired//自定义认证策略
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }



    @Bean//自定义认证的bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }

    @Bean//根据URL路由到指定登陆页面(admin/login)→登陆入口点
    public LoginUrlEntryPoint urlEntryPoint() {
        return new LoginUrlEntryPoint("/user/login");
    }

    @Bean//登陆失败的处理
    public LoginAuthFailHandler authFailHandler() {
        return new LoginAuthFailHandler(urlEntryPoint());
    }

    @Bean//认证管理器 (AuthFilter需要这个Bean)
    public AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager = super.authenticationManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationManager;
    }

    @Bean //AuthFilter
    public AuthFilter authFilter() {
        AuthFilter authFilter = new AuthFilter();
        authFilter.setAuthenticationManager(authenticationManager());
        authFilter.setAuthenticationFailureHandler(authFailHandler());
        return authFilter;
    }

}

