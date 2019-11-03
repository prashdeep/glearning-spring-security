package com.glearning.ssecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .disable()
                .csrf()
                .disable();
        http
                .authorizeRequests()
                .antMatchers("/api/v1/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/employees/**")
                .authenticated()
                .anyRequest()
                .hasRole("USER")
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/admin/**")
                .authenticated()
                .anyRequest()
                .hasAnyRole("USER","ADMIN")
                .and()
                .httpBasic();


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        /*authenticationManagerBuilder
                .inMemoryAuthentication()

                .withUser("hari")
                .password("welcome")
                .roles("USER")

                .and()

                .withUser("kiran")
                .password("testing")
                .roles("USER", "ADMIN")
                .and()

                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        */

        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());


    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}