package br.com.va4e.idac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ConfigurationProperties(prefix="app.datasource")//Get external properties
//@Import(value=org.springframework.boot.context.properties.EnableConfigura3tionPropertiesImportSelector.class) //import a configuration class
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class IdacApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdacApplication.class, args);
	}
	
	/* TODO: 
	 * Incluir Segurança (autenticação e autorização)
	 * Definir layout e criar os fragmentos (header, footer, menu, etc...)
	 * Usar HikariCP
	 * Usar Versionamento
	 * Atualizar i18n mensagens
	 * Modelos, anotação hibernate/jpa
	 * Sincronização com Contatos do Gmail.
	 * Login com Facebook e/ou G+
	 * CRUD e repositorios para modelos
	 * Validação dos formulários
	 * Customização das páginas de erro!
	 * Log em arquivo e console unico (Log4J e AOP)
	 * Definir perfis para os diferentes tipos de base e servidores
	 * MySQL/Derby/TomCat/Spring
	 * Como persistir dados para databases embebed
	 * A utilização dos perfis deve ser dinâmica e caso as bases de dados não exisatam, deverão ser criadas....
	 */
}
