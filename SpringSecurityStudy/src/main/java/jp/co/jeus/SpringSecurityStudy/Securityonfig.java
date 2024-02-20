package jp.co.jeus.SpringSecurityStudy;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Securityonfig extends WebSecurityConfiguration {
	
	private final PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Bean
	UserDetailsService authentication() {
		UserDetails peter = User.builder()
				.username("peter")
				.password(pwEncoder.encode("ppassword"))
				.roles("USER")
				.build();
		UserDetails jodie = User.builder()
				.username("jodie")
				.password(pwEncoder.encode("jpassword"))
				.roles("USER", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(peter, jodie);
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
				.authorizeRequests()
				.requestMatchers("/security-admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.build();
	}
}
