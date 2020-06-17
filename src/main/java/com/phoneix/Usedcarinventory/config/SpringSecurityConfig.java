package com.phoneix.Usedcarinventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager.authenticated;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("User")
                .password("pass")
                .roles("USER")
                .and()
                .withUser("Admin")
                .password("Admin")
                .roles("USER","ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/usedCars").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/usedCars/**").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/usedCars/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/usedCars/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/usedCars/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
