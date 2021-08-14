package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecCon extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	@Override
	@Bean
	protected  UserDetailsService userDetailsService() {
		UserDetails Dung=User.builder()
								.username("dung")
								.password(passwordEncoder.encode("123"))
								.roles("USER") //ROLE_STUDENT
								.build();
		UserDetails Binh=User.builder()
				.username("binh")
				.password(passwordEncoder.encode("123"))
				.roles("ADMIN") //ROLE_STUDENT
				.build();
		return new InMemoryUserDetailsManager(Dung,Binh);
	}
}








