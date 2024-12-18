package com.cybersolf.demojwt.config;

import com.cybersolf.demojwt.filter.CustomSecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CustomSecurityFilter customSecurityFilter) throws Exception {

        return http.csrf(csrf-> csrf.disable())
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request->
                        {
                            request.requestMatchers("/login").permitAll();
                            request.requestMatchers("/products/insert").hasRole("ADMIN");
                            request.anyRequest().authenticated();
                        }

                )
                .addFilterBefore(customSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
