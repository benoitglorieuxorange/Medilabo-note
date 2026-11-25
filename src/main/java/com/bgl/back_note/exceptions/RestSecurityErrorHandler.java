//package com.bgl.back_note.exceptions;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class RestSecurityErrorHandler implements AuthenticationEntryPoint, AccessDeniedHandler {
//
//    // 401 : pas de token, token invalide ou expiré
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException ex) throws IOException {
//        response.setHeader(HttpHeaders.WWW_AUTHENTICATE, "Bearer");
//        write(response, HttpStatus.UNAUTHORIZED, "Authentification requise ou token invalide");
//    }
//
//    // 403 : authentifié, mais rôle insuffisant
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response,
//                       AccessDeniedException ex) throws IOException {
//        write(response, HttpStatus.FORBIDDEN, "Accès refusé");
//    }
//
//    private void write(HttpServletResponse response, HttpStatus status, String detail) throws IOException {
//        response.setStatus(status.value());
//        response.setContentType("application/problem+json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("""
//                {"type":"about:blank","title":"%s","status":%d,"detail":"%s"}
//                """.formatted(status.getReasonPhrase(), status.value(), detail));
//    }
//
//}