package com.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.springcore.controller.UserController;

@Configuration
public class Config {
	//configure for classes as Springbeans

    @Bean("usercontroller")//usercontroller - object name
    //@Scope("singleton") default- creates object only once
    @Scope("prototype")// creates new object for every call(i.e getBean)
    @Profile("dev")
    public UserController getUserController() {
		return new UserController();
	}
	
}
