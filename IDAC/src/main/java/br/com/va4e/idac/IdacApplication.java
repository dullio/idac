package br.com.va4e.idac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ConfigurationProperties(prefix="app.datasource")//Get external properties
//@Import(value=org.springframework.boot.context.properties.EnableConfigurationPropertiesImportSelector.class) //import a configuration class
public class IdacApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdacApplication.class, args);
	}
}
