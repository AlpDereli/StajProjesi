package com.AlpDereli.StajProjesi.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;




@Component
public class JWTRequestFilter extends UsernamePasswordAuthenticationFilter {


    private final JWTutil jwtutil;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public JWTRequestFilter(JWTutil jwtutil, AuthenticationManager authenticationManager) {
        this.jwtutil = jwtutil;
        this.authenticationManager = authenticationManager;
    }


    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtutil.extractUsername(jwtToken);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtutil.validateToken(jwtToken, username)) {
                // Create and set authentication
                // SecurityContextHolder.getContext().setAuthentication(...);
                /*UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the Authentication in the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);*/
            }
        }

        chain.doFilter(request, response);
    }
}
