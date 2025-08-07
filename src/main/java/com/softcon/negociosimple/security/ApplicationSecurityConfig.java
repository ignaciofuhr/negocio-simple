package com.softcon.negociosimple.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {
	

	private final PasswordEncoder passwordEncoder;
	
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						// Permití el acceso a recursos estáticos y a index.html
						.requestMatchers("/", "/index.html", "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
						.anyRequest().authenticated()
				)
				.httpBasic();
		
		return http.build();
	}
	
	@Bean
	protected UserDetailsService userDetailsService(){
		var micaUser = User.builder()
				.username("micaela")
				.password(passwordEncoder.encode("mica123")) // {noop} indica que no se usará codificación de contraseña
				.roles("ADMIN")
				.build();
		
	return new InMemoryUserDetailsManager(micaUser);
	}
}

