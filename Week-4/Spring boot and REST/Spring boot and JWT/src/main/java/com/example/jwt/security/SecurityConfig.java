package com.example.jwt.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired JwtRequestFilter filter;

 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.inMemoryAuthentication()
   .withUser("admin").password("{noop}password").roles("USER");
 }

 protected void configure(HttpSecurity http) throws Exception {
  http.csrf().disable()
  .authorizeRequests()
  .antMatchers("/login").permitAll()
  .antMatchers("/api/**").authenticated()
  .and()
  .addFilterBefore(filter,
   org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);
 }
}