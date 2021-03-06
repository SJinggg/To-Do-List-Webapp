package me.sjinggg.webappplayground.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

  @Autowired
  private LoginSuccessHandler loginSuccessHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http
      .authorizeRequests().antMatchers("/api/**").authenticated()
      .and()
      .httpBasic()
        .authenticationEntryPoint(restAuthenticationEntryPoint)
      .and()
      .formLogin()
        .loginProcessingUrl("/api/login")
      .successHandler(loginSuccessHandler)
      .failureHandler(new SimpleUrlAuthenticationFailureHandler());
      http.csrf().ignoringAntMatchers("/api/login").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  }

  @Bean
  public UserDetailsService userDetailsService(){
    String pw = "password";
    String username = "username";

    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    String encodedPw = passwordEncoder().encode(pw);
    manager.createUser(User.withUsername(username).password(encodedPw).roles("USER").build());
    
    return manager;
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}






