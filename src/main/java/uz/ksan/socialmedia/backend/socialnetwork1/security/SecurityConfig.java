package uz.ksan.socialmedia.backend.socialnetwork1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }




    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->auth.requestMatchers(
                                "api/v1/users/newLoginUser",
                                "api/v1/pastebin/find/posturl/**",
                                "api/v1/pastebin/find/author/**",
                                "api/v1/users/find/**",
                                "api/v1/users/newLoginUser"
//                                "api/v1/users/find/id/**",
//                                "api/v1/users/find/name/**",
//                                "api/v1/users/find/lname/**",
//                                "api/v1/users/find/email/**",
                                ).permitAll()
                        .requestMatchers(
                                "api/v1/users/display",
                                "/api/v1/pastebin/displayall",
                                "api/v1/pastebin/createpost",
                                "api/v1/users/updateUser",
                                "api/v1/users/delete/email/**",
                                "api/v1/users/delete/id/**")
                        .authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
