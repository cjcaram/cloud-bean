package com.enano.cloudbean.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *The @EnableResourceServer annotation adds a filter of type OAuth2AuthenticationProcessingFilter automatically
 *to the Spring Security filter chain.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
      http.cors().configurationSource(corsConfigurationSource()).and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
        .antMatchers("/","/home","/login").permitAll()
        .antMatchers("/post/postComment").authenticated()
        .antMatchers("/user/**").authenticated()
        .antMatchers("/agrochemical/**").authenticated()
        .antMatchers("/agrochemical-type/**").authenticated()
        .antMatchers("/analysis/**").authenticated()
        .antMatchers("/commodity-stock/**").authenticated()
        .antMatchers("/company/**").authenticated()
        .antMatchers("/income/**").authenticated()
        .antMatchers("/land-batch/**").authenticated()
        .antMatchers("/location/**").authenticated()
        .antMatchers("/outcome/**").authenticated()
        .antMatchers("/role/**").authenticated()
        .antMatchers(HttpMethod.GET , "/post/**").permitAll()
        .antMatchers(HttpMethod.DELETE , "/post/**").hasAuthority("ROLE_ADMIN")
        .and().csrf().disable();
    }

    private CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(Arrays.asList("*"));
      configuration.addAllowedHeader("*");
      configuration.addAllowedMethod("*");
      configuration.setAllowCredentials(true);
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
    }


}
