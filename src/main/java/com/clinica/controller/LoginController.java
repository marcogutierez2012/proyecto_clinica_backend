package com.clinica.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.dto.LoginRequest;
import com.clinica.dto.LoginResponse;
import com.clinica.model.Usuario;
import com.clinica.security.MyUserDetails;
import com.clinica.service.impl.UserDetailsServiceImpl;
import com.clinica.util.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl usuarioService;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, UserDetailsServiceImpl usuarioService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }
    
    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsuario(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return null;
        }

        final UserDetails userDetails = usuarioService.loadUserByUsername(loginRequest.getUsuario());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new LoginResponse(jwt);
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public MyUserDetails obtenerUsuarioActualConDetalles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof MyUserDetails) {
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            
    
            // Print more details as needed
            return userDetails;
        }
        throw new IllegalStateException("Usuario no autenticado o tipo de usuario desconocido");
    }

}