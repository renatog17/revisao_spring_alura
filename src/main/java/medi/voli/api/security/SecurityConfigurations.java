package medi.voli.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	//o parametro http é o próprio spring que vai fornecer
	//posso d0esabilitar o csrf pois o token já é uma protecao contra esse tipo de ataque
	// a anotacao @bean serve para expor o retorno do metodo
	//com a autenticacao stateless nao sera retornado a tela de login 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().build();
	}
}
