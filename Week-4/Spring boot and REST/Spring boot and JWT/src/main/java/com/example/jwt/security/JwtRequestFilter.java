package com.example.jwt.security;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
 protected void doFilterInternal(HttpServletRequest request,
 HttpServletResponse response, FilterChain chain)
 throws IOException, ServletException {

  String header=request.getHeader("Authorization");
  // JWT validation logic can be added here

  chain.doFilter(request,response);
 }
}