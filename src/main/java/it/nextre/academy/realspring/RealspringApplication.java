package it.nextre.academy.realspring;

import it.nextre.academy.realspring.entities.Authority;
import it.nextre.academy.realspring.entities.User;
import it.nextre.academy.realspring.models.AuthorityName;
import it.nextre.academy.realspring.repositories.AuthorityRepository;
import it.nextre.academy.realspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@EnableJpaRepositories
@SpringBootApplication
public class RealspringApplication {




	@Autowired
	private DataSource datasource;
	@Autowired
	private ApplicationContext webApplicationContext;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UserRepository userRepository, AuthorityRepository authorityRepository) {
		return (args) -> {
			User user=userRepository.findByUsername("admin");
			if(user == null){
				/**
				 * Inizializzo i dati del mio test
				 */
				Authority authorityAdmin=new Authority();
				authorityAdmin.setName(AuthorityName.ROLE_ADMIN);
				authorityAdmin=authorityRepository.save(authorityAdmin);

				Authority authorityUser=new Authority();
				authorityUser.setName(AuthorityName.ROLE_USER);
				authorityUser=authorityRepository.save(authorityUser);


				List<Authority> authorities = Arrays.asList(new Authority[] {authorityAdmin,authorityUser});

				user = new User();
				user.setAuthorities(authorities);
				user.setEnabled(true);
				user.setUsername("admin");
				user.setPassword(passwordEncoder.encode("admin"));

				user = userRepository.save(user);



				List<Authority> authoritiesUser = Arrays.asList(new Authority[] {authorityUser});

				user = new User();
				user.setAuthorities(authoritiesUser);
				user.setEnabled(true);
				user.setUsername("user");
				user.setPassword(passwordEncoder.encode("user"));

				user = userRepository.save(user);

			}
		};
	}





	public static void main(String[] args) {
		SpringApplication.run(RealspringApplication.class, args);
	}
}
