package com.seamoon.pjt.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .mvcMatchers("/", "/info").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated();  //anyRequest() -> 기타 등등의 URL
                                                //authenticated() -> 인증을 하면 접근 가능

        httpSecurity.formLogin();       //Form 로그인 사용하겠다.
        httpSecurity.httpBasic();

        return httpSecurity.build();
    }

}
