package com.codegym.casestudy_spring_module_4.config;

import com.codegym.casestudy_spring_module_4.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();

        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/customer/**").access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_CUSTOMER')");
        http.authorizeRequests().antMatchers("/employee/**", "/contract/**", "/facilities/**").hasRole("EMPLOYEE");

        //http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        // thiết lập action trả về khi truy cập trang không có quyền
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/deny");

        http.authorizeRequests().and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");

        http
                .rememberMe().tokenValiditySeconds(60 * 60 * 24 * 1); // 1 day
    }
}
