/*package com.AlpDereli.StajProjesi.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import com.AlpDereli.StajProjesi.security.JWTutil;



@Component
public class JWTRequestFilter extends OncePerRequestFilter {


    private final JWTutil jwtutil;
    //private final AuthenticationManager authenticationManager;


    @Autowired
    public JWTRequestFilter(JWTutil jwtutil) {
        this.jwtutil = jwtutil;
        //this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {

        String path = request.getRequestURI();
        if ("/login".equals(path)) {
            filterChain.doFilter(request, response);
            return;
        }
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
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);////////
            }
        }
        filterChain.doFilter(request, response);
    }
}*/
