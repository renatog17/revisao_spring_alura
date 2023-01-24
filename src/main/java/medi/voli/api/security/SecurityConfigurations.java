package medi.voli.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	//o parametro http é o próprio spring que vai fornecer
	//posso d0esabilitar o csrf pois o token já é uma protecao contra esse tipo de ataque
	// a anotacao @bean serve para expor o retorno do metodo
	//com a autenticacao stateless nao sera retornado a tela de login 
	//configuracoes de seguranca sao efetuadas aqui
	//o Bean serve para exportar uma classe para o Spring, fazendo com que a classe seja carregada com as informacoes
	//personalizadas
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().build();
	}
	//este metodo e necessario para que o spring seja capaz de injetar AuthenticationManager na classe AutenticationController
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
