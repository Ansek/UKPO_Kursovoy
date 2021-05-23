/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ansek.ukpo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Александр
 */
@Configuration
@EnableWebSecurity 
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/home", "/", "/css/**", "/js/**", "/images/**", "/public/rest/**")
                            .permitAll().and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
    }
}