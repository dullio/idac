package br.com.va4e.idac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dullio
 *
 *
 *Classe para configurações do Spring Boot
 *Novas configurações e sobrescrever as automáticas que forem necessárias
 */
@Configuration
@ComponentScan(basePackages="br.com.va4e.idac")
@EnableJpaRepositories(basePackages = "br.com.va4e.idac.repository")
public class IdacWebConfig  {


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
}


}