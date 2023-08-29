package sia.tacocloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sia.tacocloud.User;
import sia.tacocloud.data.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }

            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/design", "/orders/**").authenticated()
                                .requestMatchers("/", "/**").permitAll()
                )
//                .headers(headersConfigurer -> headersConfigurer
//                                                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
//                )
//                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .defaultSuccessUrl("/design", true)
                )
                // TODO: Add ability to log out. This may involve creating a user session attribute.
                .oauth2Login(
                        oauth2 -> oauth2
                                .loginPage("/login")
                );

        return http.build();
    }
}
