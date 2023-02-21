package ca.sheridancollege.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**","/images/**").permitAll()
				.antMatchers("/","/error","/volunteer/**","/customer/**","/about", "/donate").permitAll()
				.antMatchers("/adminDashboard/**").authenticated()
				.anyRequest().authenticated()
				.and()

			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/adminDashboard/volunteerApplicants", true)
				.permitAll()
				.and()

			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				
			.exceptionHandling()
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/* FOR TESTING ONLY */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				// FOR TESTING ONLY - remove in production
				.antMatchers("/h2-console/**"); 

	}
	
	/* In memory authentication - FOR TESTING ONLY */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("user").password(bCryptPasswordEncoder().encode("pass")).roles("ADMIN");
//	}
	
}
