package com.monocept.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Bean
	SecurityFilterChain filterChain( HttpSecurity security) throws Exception
	{
		security.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("Student", "Admin")
												.requestMatchers(HttpMethod.POST,"/api/students/create/**").hasRole("Admin")
												.requestMatchers(HttpMethod.PUT,"/api/students/**").hasAnyRole("Student", "Admin")
												.requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole("Admin")
												.anyRequest().authenticated()
												).httpBasic(Customizer.withDefaults())
												.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return security.build();
	}
	
	@Bean
	UserDetailsService detailsService(PasswordEncoder encoder)
	{
		UserDetails admin = User.builder().username("Admin").password(encoder.encode("Admin123")).roles("Admin").build();
		UserDetails student = User.builder().username("Student").password(encoder.encode("Student123")).roles("Student").build();
		return new InMemoryUserDetailsManager(admin, student);
	}
	
	@Bean
	 PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
