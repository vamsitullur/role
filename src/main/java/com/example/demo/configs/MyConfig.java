package com.example.demo.configs;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.RestTemplate;



//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//	private final AuthenticationProvider authenticationProvider;
//	private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//	public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter,
//			AuthenticationProvider authenticationProvider) {
//		this.authenticationProvider = authenticationProvider;
//		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//	}
//
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeHttpRequests().requestMatchers("/auth/**").permitAll().anyRequest()
////				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////				.authenticationProvider(authenticationProvider)
////				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
////
////		return http.build();
////	}
//	


	@Configuration
	public class MyConfig {
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	                .csrf(csrf -> csrf.disable())
	                .cors(cors -> cors.disable())
	                .authorizeHttpRequests(req -> req
	                        
	                        .requestMatchers("/api/getApi").hasRole("ADMIN").anyRequest().authenticated()
	                       ).httpBasic(Customizer.withDefaults());
	        return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	                  return new BCryptPasswordEnc   
  
	        		public UserDetailsService userDetailsService() {
	        UserDetails user = User.builder()
	                .username("user")
	                .password(passwordEncoder().encode("user123"))
	                .roles("USER")
	                .build();
	        UserDetails admin = User.builder()
	                .username("admin")
	                .password(passwordEncoder().encode("admin123"))
	                .roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(user,admin);
	    

	
	    }
	    }
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
	           http
	                   .csrf(csrf -> csrf.disable())
	                   .cors(cors -> cors.disable())
	                   .authorizeHttpRequests(req -> req
	                           .requestMatchers("/public/api/*").permitAll()
	                           .requestMatchers("/api/getApi").hasRole("ADMIN").anyRequest().authenticated()
	                           .requestMatchers("api/getAll").hasAnyRole("ADMIN","USER").anyRequest().authenticated()
	                          ).httpBasic(Customizer.withDefaults());
	           return http.build();
	       }
	


//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//       .csrf().disable()
//       .authorizeHttpRequests((reuests)->reuests
//    		  
//            .requestMatchers("/auth/**").hasRole("ADMIN")  
//            .requestMatchers("/auth/me").hasAnyRole("USER", "ADMIN")  // Users or Admin can access /user
//          
//            .anyRequest().authenticated()
//            )
//       .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//    
//    
//    
//    return http.build();
//
//   
//}
//

//@Bean
//CorsConfigurationSource corsConfigurationSource() {
//    CorsConfiguration configuration = new CorsConfiguration();
//
//    configuration.setAllowedOrigins(List.of("http://localhost:8005"));
//    configuration.setAllowedMethods(List.of("GET","POST"));
//    configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
//
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//    source.registerCorsConfiguration("/**",configuration);
//
//    return source;
//
//
//}


}
