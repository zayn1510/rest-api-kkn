package com.api.kkn.app;

import com.api.kkn.app.entity.Role;
import com.api.kkn.app.entity.Users;
import com.api.kkn.app.repository.UserRepository;
import com.api.kkn.app.util.PasswordHasher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiKknApplication implements CommandLineRunner {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ApiKknApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
