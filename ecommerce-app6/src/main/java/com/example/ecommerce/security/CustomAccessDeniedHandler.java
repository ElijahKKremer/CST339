package com.example.ecommerce.security;

import jakarta.servlet.ServletException;  // Use jakarta.servlet instead of javax.servlet
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {

    @Override
    public void handle(
            jakarta.servlet.http.HttpServletRequest request,   // Use jakarta.servlet
            jakarta.servlet.http.HttpServletResponse response,  // Use jakarta.servlet
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        
        response.sendRedirect("/accessDenied");  // Redirect to the custom access denied page
    }
}
