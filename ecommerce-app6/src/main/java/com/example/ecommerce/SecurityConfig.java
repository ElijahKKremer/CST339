package com.example.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.example.ecommerce.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final AccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(CustomUserDetailsService userDetailsService, AccessDeniedHandler accessDeniedHandler) {
        this.userDetailsService = userDetailsService;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/css/**", "/js/**", "/images/**").permitAll()  // Permit all for login, register, and static resources
                .requestMatchers("/about", "/products").authenticated()  // Require authentication for about and products pages
                .anyRequest().authenticated()  // Secure all other pages
            )
            .userDetailsService(userDetailsService)  // Ensure custom user details service is used for authentication
            .formLogin(form -> form
                .loginPage("/login")  // Custom login page URL
                .permitAll()  // Allow everyone to access the login page
            )
            .logout(logout -> logout
                .permitAll()  // Allow everyone to log out
            )
            .exceptionHandling(ex -> ex
                .accessDeniedHandler(accessDeniedHandler));  // Use the custom access denied handler
        return http.build();
    }
}
