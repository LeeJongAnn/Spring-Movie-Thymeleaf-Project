package com.spring.MovieProject.config;


import com.spring.MovieProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public DetailsUserService pilotUserDetailsServices() {
        return new DetailsUserService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider certification = new DaoAuthenticationProvider();
        certification.setUserDetailsService(pilotUserDetailsServices());
        certification.setPasswordEncoder(passwordEncoder());
        return certification;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        authorize -> authorize
                                .anyRequest().permitAll()
                ).formLogin((login) -> login.loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/v1/popular/1"))

                .logout(logout -> logout.logoutUrl("/v1/logout").logoutSuccessUrl("/v1/popular/1"));

        http.authenticationProvider(authenticationProvider());
        return http.build();
    }
}