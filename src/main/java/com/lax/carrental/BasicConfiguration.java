package com.lax.carrental;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //För att H2-console inloggningsformuläret ska fungera
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/cars**").hasRole("USER")
                .antMatchers("/api/v1/ordercar**").hasRole("USER")
                .antMatchers("/api/v1/updateorder**").hasRole("USER")
                .antMatchers("/api/v1/myorders**").hasRole("USER")
                .antMatchers("/api/v1/onecustomersorders**").hasRole("USER")
                .antMatchers("/api/v1/customers**").hasRole("ADMIN")
                .antMatchers("/api/v1/addcar**").hasRole("ADMIN")
                .antMatchers("/api/v1/deletecar**").hasRole("ADMIN")
                .antMatchers("/api/v1/updateecar**").hasRole("ADMIN")
                // Tillåter access till h2-console som ADMIN roll
                .antMatchers("/h2-console/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        //Används för att avaktivera X-Frame-Options. Kan köra utan det om vi tänker oss H2 databasen som ren utvecklingsdatabas.
        http.headers().frameOptions().disable();
    }
}