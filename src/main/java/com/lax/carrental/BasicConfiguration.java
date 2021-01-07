package com.lax.carrental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("Winston")
                .password(encoder.encode("test"))
                .roles("USER")
                .and()
                .withUser("Standford")
                .password(encoder.encode("test"))
                .roles("USER")
                .and()
                .withUser("Wallace")
                .password(encoder.encode("test"))
                .roles("USER")
                .and()
                .withUser("Bob")
                .password(encoder.encode("test"))
                .roles("USER")
                .and()
                .withUser("Bruce")
                .password(encoder.encode("test"))
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
                .cors().and()
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
                .antMatchers("/api/v1/currentUser**").hasRole("USER")
                // Tillåter access till h2-console som ADMIN roll
                .antMatchers("/h2-console/**").hasRole("ADMIN")
                .antMatchers("/login*").permitAll()
                .antMatchers("/perform_logout*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .defaultSuccessUrl("http://localhost:5001", false)
                .failureUrl("/login.html?error=true");


        http
                .logout().clearAuthentication(true)
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");


        //Används för att avaktivera X-Frame-Options. Kan köra utan det om vi tänker oss H2 databasen som ren utvecklingsdatabas.
        http.headers().frameOptions().disable();
    }


}