package jp.co.jeus.SpringSecurityStudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Securityonfig {
	
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
}
