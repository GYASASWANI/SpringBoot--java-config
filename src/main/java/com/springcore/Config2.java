package com.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.springcore.repository.UserRespository;
import com.springcore.repository.impl.UserRespositoryImpl;
import com.springcore.service.UserService;
import com.springcore.service.impl.UserServiceImpl;

@Configuration
//@ImportResource("beans.xml") // importing xml file in resources
@Import(Config.class)
public class Config2 {

    @Bean
	public UserService getUserService() {
		return new UserServiceImpl();
	}
    @Bean //getUserRespository will be default object name
	public UserRespository getUserRespository() {
		return new UserRespositoryImpl();
	}
}
