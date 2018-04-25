package br.com.va4e.idac.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="br.com.va4e.idac")
@PropertySource("classpath:database-persistence.properties")
public class DatabaseConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	// define a bean for our security datasource
	
		@Bean
		public DataSource securityDataSource() {
			
			// create connection pool
			ComboPooledDataSource securityDataSource
										= new ComboPooledDataSource();
					
			// set the jdbc driver class
			
			try {
				securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			} catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}
			
			// log the connection props
			// for sanity's sake, log this info
			// just to make sure we are REALLY reading data from properties file
			
			logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
			logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
			
			
			// set database connection props
			
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));
			
			// set connection pool props
			
			securityDataSource.setInitialPoolSize(
					getIntProperty("connection.pool.initialPoolSize"));

			securityDataSource.setMinPoolSize(
					getIntProperty("connection.pool.minPoolSize"));

			securityDataSource.setMaxPoolSize(
					getIntProperty("connection.pool.maxPoolSize"));

			securityDataSource.setMaxIdleTime(
					getIntProperty("connection.pool.maxIdleTime"));
			
			return securityDataSource;
		}
		
		
		@Bean
		public DataSource DataSource() {
			
			// create connection pool
			ComboPooledDataSource DataSource
										= new ComboPooledDataSource();
					
			// set the jdbc driver class
			
			try {
				DataSource.setDriverClass(env.getProperty("idac.datasource.driver-class-name"));
			} catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}
			
			// log the connection props
			// for sanity's sake, log this info
			// just to make sure we are REALLY reading data from properties file
			
			logger.info(">>>Database jdbc.url=" + env.getProperty("idac.datasource.url"));
			logger.info(">>>Database jdbc.user=" + env.getProperty("idac.datasource.username"));
			
			
			// set database connection props

			DataSource.setJdbcUrl(env.getProperty("idac.datasource.url"));
			DataSource.setUser(env.getProperty("idac.datasource.username"));
			DataSource.setPassword(env.getProperty("idac.datasource.password"));
			
			// set connection pool props
			
			DataSource.setInitialPoolSize(
					getIntProperty("idac.connection.pool.initialPoolSize"));

			DataSource.setMinPoolSize(
					getIntProperty("idac.connection.pool.minPoolSize"));

			DataSource.setMaxPoolSize(
					getIntProperty("idac.connection.pool.maxPoolSize"));

			DataSource.setMaxIdleTime(
					getIntProperty("idac.connection.pool.maxIdleTime"));
			
			return DataSource;
		}
		// need a helper method 
		// read environment property and convert to int
		
		private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// now convert to int
			int intPropVal = Integer.parseInt(propVal);
			
			return intPropVal;
		}
	


}
