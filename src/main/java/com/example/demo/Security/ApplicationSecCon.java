package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.demo.Security.UserPermission.*;

import java.util.concurrent.TimeUnit;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
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
//			.antMatchers(HttpMethod.DELETE,"/admin/**").hasAuthority(UserPermission.ADMIN_DELETE.getPermission())
//			.antMatchers(HttpMethod.POST,"/admin/**").hasAuthority(UserPermission.ADMIN_WRITE.getPermission())
//			.antMatchers(HttpMethod.PUT,"/admin/**").hasAuthority(UserPermission.ADMIN_UPDATE.getPermission())
//			.antMatchers(HttpMethod.GET,"/admin/**").hasAnyRole(UserRole.ADMIN.name(),UserRole.COLLAB.name())
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/welcome", true)
			.and()
			.rememberMe()
				.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))//default 2 week
				.key("somethingverysecured")	//hash information of user
			.and()
			.logout()
				.logoutUrl("/logout")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID","remember-me")
				.logoutSuccessUrl("/login");
		http.headers().frameOptions().disable();
	}
	@Override
	@Bean
	protected  UserDetailsService userDetailsService() {
		UserDetails Dung=User.builder()
								.username("dung")
								.password(passwordEncoder.encode("123"))
//								.roles(UserRole.USER.name()) //ROLE_STUDENT
								.authorities(UserRole.USER.getGrandtedAuthorities())
								.build();
		UserDetails Binh=User.builder()
								.username("binh")
								.password(passwordEncoder.encode("123"))
//								.roles(UserRole.ADMIN.name()) //ROLE_ADMIN
								.authorities(UserRole.ADMIN.getGrandtedAuthorities())
								.build();
		UserDetails Tien=User.builder()
								.username("tien")
								.password(passwordEncoder.encode("123"))
//								.roles(UserRole.COLLAB.name()) //ROLE_COLAB
								.authorities(UserRole.COLLAB.getGrandtedAuthorities())
								.build();
		return new InMemoryUserDetailsManager(Dung,Binh,Tien);
	}
}








