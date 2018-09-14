package com.enano.cloudbean.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *The @EnableResourceServer annotation adds a filter of type OAuth2AuthenticationProcessingFilter automatically
 *to the Spring Security filter chain.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
      http
      .authorizeRequests()
      .antMatchers("/","/home","/register","/login").permitAll()
      .antMatchers("/private/**").authenticated()
      .antMatchers("/post").authenticated()
      .antMatchers("/post/postComment").authenticated()
      .antMatchers(HttpMethod.GET , "/post/**").permitAll()
      .antMatchers(HttpMethod.DELETE , "/post/**").hasAuthority("ROLE_ADMIN");

      
      /*http
            .headers()
                .frameOptions()
                .disable()
                .and()
            .authorizeRequests()
                .antMatchers("/","/home","/register","/login","/oauth/authorize","/oauth/authorize", "/oauth/token**").permitAll()
                .antMatchers("/private/**").authenticated()
                .antMatchers("/post").authenticated()
                .and()
                .formLogin().permitAll();
        
        */
        
//      http.requestMatchers()
//        .antMatchers("/","/home","/register","/login","/oauth/authorize")
//        .and()
//        .authorizeRequests()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .formLogin()
//        .permitAll();
    }


}
