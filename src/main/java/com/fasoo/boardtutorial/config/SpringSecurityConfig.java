package com.fasoo.boardtutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select user_Id, user_pw, enabled from user where user_id=?"
                )
                .authoritiesByUsernameQuery(
                        "select user_id, role from user_role where user_id=?"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/", "/h2-console/**").permitAll()
                    .antMatchers("/board/**", "/post/**").hasRole("USER")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("userId")
                    .passwordParameter("password")
                .and()
                    .csrf()
                        .ignoringAntMatchers("/h2-console/**")
                .and()
                    .headers().
                        frameOptions().
                            disable()
                .and()
                    .headers()
                        .httpStrictTransportSecurity()
                            .disable();
    }
}
