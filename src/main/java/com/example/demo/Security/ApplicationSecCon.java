package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.demo.Security.UserPermission.*;
@Configuration
@EnableWebSecurity
public class ApplicationSecCon extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").hasRole(UserRole.USER.name())
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers(HttpMethod.DELETE,"/admin/**").hasAnyRole(UserRole.ADMIN.name())
			.antMatchers(HttpMethod.POST,"/admin/**").hasAnyRole(UserRole.ADMIN.name())
			.antMatchers(HttpMethod.PUT,"/admin/**").hasAnyRole(UserRole.ADMIN.name())
			.antMatchers(HttpMethod.GET,"/admin/**").hasAnyRole(UserRole.ADMIN.name(),UserRole.COLLAB.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
		http.headers().frameOptions().disable();
	}
	@Override
	@Bean
	protected  UserDetailsService userDetailsService() {
		UserDetails Dung=User.builder()
								.username("dung")
								.password(passwordEncoder.encode("123"))
								.roles(UserRole.USER.name()) //ROLE_STUDENT
								.build();
		UserDetails Binh=User.builder()
				.username("binh")
				.password(passwordEncoder.encode("123"))
				.roles(UserRole.ADMIN.name()) //ROLE_ADMIN
				.build();
		UserDetails Tien=User.builder()
				.username("tien")
				.password(passwordEncoder.encode("123"))
				.roles(UserRole.COLLAB.name()) //ROLE_COLAB
				.build();
		return new InMemoryUserDetailsManager(Dung,Binh,Tien);
	}
}








