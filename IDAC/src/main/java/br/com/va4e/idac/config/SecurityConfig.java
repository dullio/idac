package br.com.va4e.idac.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder).dataSource(dataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
		http.authorizeRequests()
		//.anyRequest().authenticated()

				// .antMatchers("/index").anonymous()
				.antMatchers("/**").anonymous()
				//.and().antMatcher("/static/**").anonymous()
				// .antMatchers("/member/**").hasRole("MANAGER")
				// .antMatchers("/members/**").anonymous()
				// .antMatchers("/leaders/**").hasRole("MANAGER")
				// .antMatchers("/systems/**").hasRole("ADMIN")
				.and().formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
				.and().logout().deleteCookies("remove").invalidateHttpSession(false).logoutUrl("/logout")
				.logoutSuccessUrl("/").permitAll().and().exceptionHandling().accessDeniedPage("/error/403");

	}
	
	

}
