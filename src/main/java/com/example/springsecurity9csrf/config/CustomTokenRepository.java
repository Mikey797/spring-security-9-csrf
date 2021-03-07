package com.example.springsecurity9csrf.config;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomTokenRepository implements CsrfTokenRepository {

    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", "alwaysmake this andom unpredicatable");
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    @Override
    public CsrfToken loadToken(HttpServletRequest httpServletRequest) {
        return null;
    }
}
