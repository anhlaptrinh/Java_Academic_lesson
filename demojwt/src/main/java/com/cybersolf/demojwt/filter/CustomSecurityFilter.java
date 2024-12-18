package com.cybersolf.demojwt.filter;


import com.cybersolf.demojwt.utils.JwtHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSecurityFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authenHeader = request.getHeader("Authorization");
        if(authenHeader!=null && authenHeader.startsWith("Bearer ")){
            //Authen header co gia tri
            String token = authenHeader.substring(7);

            boolean isSuccess=jwtHelper.deccript(token);
            if(isSuccess){
                String role = jwtHelper.getDataToken(token);
                List<SimpleGrantedAuthority> authoritiesList = new ArrayList<>();
                SimpleGrantedAuthority roleAuthority = new SimpleGrantedAuthority(role);
                authoritiesList.add(roleAuthority);
                SecurityContext securityContext= SecurityContextHolder.getContext();
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken("","", authoritiesList);
                securityContext.setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}