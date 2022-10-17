package com.juyn.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.juyn.configs.handlersAfterLoginLogout.AfterLogin;
import com.juyn.configs.handlersAfterLoginLogout.AfterLogout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.juyn.repository", "com.juyn.service"})
public class SecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler afterLogin;
    @Autowired
    private LogoutSuccessHandler afterLogout;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddq8il5ve", "api_key", "937185955892689", "api_secret", "R2uRiFdU3hp8QoK9sD4wv-luCTk", "secure", true));
        return c;
    }
    
    @Bean
    public AuthenticationSuccessHandler afterLogin(){
        return new AfterLogin();
    }
    
    @Bean
    public LogoutSuccessHandler afterLogout(){
        return new AfterLogout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/user/login").usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/user/login?error");
        
        http.formLogin().successHandler(this.afterLogin);// After LoginSuccess Not Run defaultSuccess NOW run this.
        
        http.logout().logoutSuccessUrl("/user/login");   //Out
        http.logout().logoutSuccessHandler(this.afterLogout);
        
        http.exceptionHandling().accessDeniedPage("/");
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        //.antMatchers("/**/add").access("hasRole('ROLE_ADMIN')");
        //.antMatchers("").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        http.csrf().disable();
    }
}
