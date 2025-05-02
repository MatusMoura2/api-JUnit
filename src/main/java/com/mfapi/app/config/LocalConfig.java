package com.mfapi.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mfapi.app.domain.User;
import com.mfapi.app.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository userRepository;

	@Bean
	public void startDB() {
		User user01 = new User(null,"Matus","matus.moura@gmail.com","123");
		User user02 = new User(null,"Beatriz","beatri.moura@gmail.com","4123");
		User user03 = new User(null,"Doni","doni.moura@gmail.com","54123");
		User user04 = new User(null,"Luna","luna.moura@gmail.com","654123");
		
		userRepository.saveAll(List.of(user01,user02,user03,user04));
	}
}
