package com.ippf.havendac.business.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityFilterConfig {
    private SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/users/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/api/properties/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/properties").hasRole("")
                        .requestMatchers(HttpMethod.PUT, "/api/properties/{id}").hasRole("")
                        .requestMatchers(HttpMethod.DELETE, "/api/properties/{id}").hasRole("") //configurar

                        .requestMatchers(HttpMethod.GET, "/api/rooms/{id}").hasRole("")
                        .requestMatchers(HttpMethod.POST, "/api/rooms").hasRole("")
                        .requestMatchers(HttpMethod.PUT, "/api/rooms/{id}").hasRole("")
                        .requestMatchers(HttpMethod.DELETE, "/api/rooms/{id}").hasRole("")

                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
