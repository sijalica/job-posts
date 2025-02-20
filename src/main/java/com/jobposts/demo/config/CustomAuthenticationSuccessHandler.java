package com.jobposts.demo.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        System.out.println("Username is: " + username + ".It is logged in");
        boolean hasJobSeekerRole = authentication.getAuthorities().stream().anyMatch(r -> "Job Seeker".equals(r.getAuthority()));
        boolean hasRecruiterRole = authentication.getAuthorities().stream().anyMatch(r -> "Recruiter".equals(r.getAuthority()));
        if (hasJobSeekerRole || hasRecruiterRole) {
            response.sendRedirect("/dashboard");
        }
    }
}
