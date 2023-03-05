package com.tn.config;

import com.tn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .authorizeRequests()
                    .antMatchers(
                            "/account/add*","/account/add/**",
                            "/account/delete/**",
                            "/account/update/**"
                    ).hasAnyAuthority("ADMIN","MANAGER")
                    .antMatchers(
                            "/department/add**","/department/add/**",
                            "/department/delete/**",
                            "/department/update/**",
                            "/department/deletelist**",
                            "/department**", "/department/**"
                    ).hasAnyAuthority("ADMIN","MANAGER")
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .csrf().disable(); // chống tấn công

    }
}
