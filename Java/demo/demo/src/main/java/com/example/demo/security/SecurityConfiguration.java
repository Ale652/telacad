// package com.example.demo.security;

// import com.example.demo.security.AuthTokenFilter;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableMethodSecurity
// public class SecurityConfiguration {

//     @Autowired
//     UserDetailsServiceImplementation userDetailsService;

//     @Autowired
//     private AuthExceptionHandler unauthorizedHandler;

//     @Autowired
//     private AccessDeniedHandler accessDeniedHandler;

//     @Bean
//     public AuthTokenFilter authenticationJwtTokenFilter() {
//         return new AuthTokenFilter();
//     }

//     @Bean
//     public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.cors().and().csrf().disable()
//                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                 // .and()
//                 // .authorizeRequests().antMatchers(HttpMethod.POST, "/user/**").hasAnyAuthority("ADMIN")
//                 // .and()
//                 // .authorizeRequests().antMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ADMIN", "USER")
//                 // .and()
//                 // .authorizeRequests().antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
//                 // .and()
//                 // .authorizeRequests().antMatchers("/user/**").permitAll()
//                 // .anyRequest().authenticated()
//                 // .and()
//         //         .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).accessDeniedHandler(accessDeniedHandler);

//         // http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//         return http.build();
//     }
// }
