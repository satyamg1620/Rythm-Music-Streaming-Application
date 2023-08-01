package com.rythm.musicDemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DemoSecurityConfig {

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
	 * john =
	 * User.builder().username("john").password("{noop}test123").roles("USER").build
	 * (); UserDetails mary =
	 * User.builder().username("mary").password("{noop}test123").roles("USER").build
	 * (); UserDetails satyam =
	 * User.builder().username("satyam").password("{noop}test123").roles("USER",
	 * "ADMIN").build();
	 * 
	 * return new InMemoryUserDetailsManager(john, mary, satyam); }
	 */
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource) {
		JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(datasource);
		
		theUserDetailsManager
			.setUsersByUsernameQuery("SELECT username, password, active FROM members where username=?");
		
		theUserDetailsManager
			.setAuthoritiesByUsernameQuery("SELECT username, role FROM roles where username=?");
		
		return theUserDetailsManager;
	}
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("USER")
				.requestMatchers("/users/**").hasRole("ADMIN")

				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
						.permitAll())
				.logout(logout -> logout.permitAll())
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

		return http.build();
	}
}
