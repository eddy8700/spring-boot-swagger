package com.spring.swagger2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/swagger-resources").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
