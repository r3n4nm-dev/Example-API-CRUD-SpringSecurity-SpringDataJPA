package com.renanmateus.authorizefuncionario.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder codificasenha() {
		return new BCryptPasswordEncoder();

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/funcionarios/","/funcionarios").permitAll()
		.antMatchers(HttpMethod.POST,"/funcionarios/").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.DELETE,"/funcionarios/*").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/funcionarios/*").hasRole("ADMIN")
		.anyRequest().authenticated().and().csrf().disable()
		.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("renan")
		.password(codificasenha().encode("renan"))
		.roles("ADMIN")
		.and()
		.withUser("aline")
		.password(codificasenha().encode("aline"))
		.roles("USER");

	}

	
}
