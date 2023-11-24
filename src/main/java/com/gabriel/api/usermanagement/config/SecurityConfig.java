package com.gabriel.api.usermanagement.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled=true,prePostEnabled=true,jsr250Enabled=true)
public class SecurityConfig {

    @Autowired
    private Environment env;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.csrf(c->c.disable());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        String user = env.getProperty("security-cred.user");
        String password = env.getProperty("security-cred.password");
        UserDetails userCred = User.builder()
                .username(user)
                .password(encoder().encode(password))
                .build();
        return new InMemoryUserDetailsManager(userCred);
    }
}
