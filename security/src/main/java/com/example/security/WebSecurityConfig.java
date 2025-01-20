package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests((requests) -> requests
        .requestMatchers("/", "/home").permitAll()
        .requestMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
      )
      .formLogin((form) -> form
        .loginPage("/login")
        .permitAll()
      )
      .logout((logout) -> logout.permitAll());
    
    http.exceptionHandling(ex -> ex.accessDeniedPage("/error403.html"));
    http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));
    
    return http.build();
  }
  
  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
    return new CustomAccessDeniedHandler();
  }
  
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user =
      User.withDefaultPasswordEncoder()
        .username("user")
        .password("1111")
        .roles("USER")
        .build();
    
    UserDetails admin =
      User.withDefaultPasswordEncoder()
        .username("admin")
        .password("1111")
        .roles("ADMIN")
        .build();
    
    return new InMemoryUserDetailsManager(user, admin);
  }
}