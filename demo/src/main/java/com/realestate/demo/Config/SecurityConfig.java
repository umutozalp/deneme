package com.realestate.demo.Config;


import com.realestate.demo.Service.RealestateUsersService;
import com.realestate.demo.Service.RealestateUsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable() )
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/contract/view/**","/contract/view").hasRole("LAWYER");
                    authorize.requestMatchers("expense/create","/income/create").hasRole("ACCOUNTANT");
                    authorize.requestMatchers("/**").hasRole("ADMIN");
                    authorize.anyRequest().authenticated();
                }).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
               .httpBasic(Customizer.withDefaults())
               .build();
    }

    //Uygulamada kullanıcı kimlik doğrulaması için hangi servisi ve hangi password encoder'ı kullanacığını belirlemek amacıyla tanımlanır.
    //Service sınıfında oluşturduğumuz kimlik doğrulamayı yani userDetailsService'i işaret ediyoruz.
    @Bean
    public AuthenticationProvider authenticationProvider(RealestateUsersServiceImpl realestateUsersServiceImpl) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(realestateUsersServiceImpl);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
