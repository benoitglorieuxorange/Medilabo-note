//package com.bgl.back_note.security;
//
//import com.bgl.back_note.exceptions.RestSecurityErrorHandler;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    private SecretKey key() {
//        return new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, RestSecurityErrorHandler errorHandler) throws Exception {
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/note/**").permitAll()
//                    //    .requestMatchers("/api/note/**").authenticated()
//                        .anyRequest().authenticated())
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(errorHandler)
//                        .accessDeniedHandler(errorHandler))
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .authenticationEntryPoint(errorHandler)
//                        .accessDeniedHandler(errorHandler)
//                        .jwt(jwt -> jwt.jwtAuthenticationConverter(converter())));
//
//        return http.build();
//
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withSecretKey(key()).macAlgorithm(MacAlgorithm.HS256).build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    // Transforme le claim "roles": ["ADMIN"] en authority ROLE_ADMIN
//    private JwtAuthenticationConverter converter() {
//        JwtGrantedAuthoritiesConverter authorities = new JwtGrantedAuthoritiesConverter();
//        authorities.setAuthoritiesClaimName("roles");
//        authorities.setAuthorityPrefix("ROLE_");
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        converter.setJwtGrantedAuthoritiesConverter(authorities);
//        return converter;
//    }
//
//
//}
