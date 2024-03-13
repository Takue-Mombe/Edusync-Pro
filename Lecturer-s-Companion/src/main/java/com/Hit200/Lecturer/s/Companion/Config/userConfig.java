package com.Hit200.Lecturer.s.Companion.Config;


import com.Hit200.Lecturer.s.Companion.Services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class userConfig {
    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return (username) -> userService
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.POST, "/users/register").permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable); // Disable CSRF protection

        return http.build();
    }
}
