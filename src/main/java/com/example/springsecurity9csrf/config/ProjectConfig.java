package com.example.springsecurity9csrf.config;

import com.example.springsecurity9csrf.CSRFTokenLoggerFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // this will not csrf token to the form
        /*
        whe yo load the page spring security will generate a token (nobody can guess)
        and spring will automatically inject the token only in the login page
        you have to add it for your own forms

        spring will use both session and the token to validate requests

        attackers will not be able to attack without this token
         */
//        http.csrf().disable();

        /*
        we can pring the token by printing the filter because we added the filer after the
        csrf filter.
         */
        http.addFilterAfter(new CSRFTokenLoggerFilter(), CsrfFilter.class);


        /*
        this is how you customize csrf token
         */
        http.csrf(c -> {
//            c.csrfTokenRepository(new CustomTokenRepository());
        });
    }
}
