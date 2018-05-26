package br.com.va4e.idac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ConfigurationProperties(prefix="app.datasource")//Get external properties
//@Import(value=org.springframework.boot.context.properties.EnableConfigura3tionPropertiesImportSelector.class) //import a configuration class
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class IdacApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdacApplication.class, args);
		 
	       
	}
	
	/* TODO: 
	 * Incluir Segurança (autenticação e autorização)
	 * Definir layout e criar os fragmentos (header, footer, menu, etc...)
	 * Usar HikariCP - ok
	 * Usar Versionamento
	 * Auditoria
	 * dataCriacao dataAtuaizacao e ultimo usuário
	 * Atualizar i18n mensagens
	 * Modelos, anotação hibernate/jpa
	 * Sincronização com Contatos do Gmail.
	 * Login com Facebook e/ou G+
	 * CRUD e repositorios para modelos
	 * Validação dos formulários
	 * Customização das páginas de erro! Whitelabel Error Page
	 * Log em arquivo e console unico (Log4J e AOP)
	 * Definir perfis para os diferentes tipos de base e servidores
	 * MySQL/Derby/TomCat/Spring
	 * Como persistir dados para databases embebed
	 * A utilização dos perfis deve ser dinâmica e caso as bases de dados não exisatam, deverão ser criadas....
	 * Como criar msg internacionalizada com variaveis no meio do texto
	 * Nos campos de auditoria ver os campos que não podem ser nulos e/ou atualizados
	 */
   

}
