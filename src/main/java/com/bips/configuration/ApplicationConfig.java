package com.bips.configuration;

import com.bips.AuthEventHandler;
import com.bips.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by ahadcse on 18/03/16.
 */
@Configuration
public class ApplicationConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(initMethod = "init")
    public UserManager userManager() {
        return new UserManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEventPublisher authEventHandler() {
        return new AuthEventHandler();
    }
}