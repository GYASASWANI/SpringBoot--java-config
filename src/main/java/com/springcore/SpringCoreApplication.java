package com.springcore;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springcore.controller.UserController;
import com.springcore.vo.UserVO;

@SpringBootApplication
@ComponentScan("com.springcore") // specify config file package
public class SpringCoreApplication {

	public static void main(String[] args) {
		
// 	    //creating object to IOC container with i/p as Config class using java config approach
//		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
//	    System.out.println(ac);
	    
		ConfigurableApplicationContext ac=SpringApplication.run(SpringCoreApplication.class, args); 
	    System.out.println(ac);
		
		
		
		//If Singleton-controller = controller1; else different objects   
	    UserController controller = ac.getBean("usercontroller", UserController.class);
	    UserController controller1 = ac.getBean("usercontroller", UserController.class);
	    
	    UserVO user1 = new UserVO(123, "sai", "vnm");
	    System.out.println("no. of users added:"+controller.addUser(user1));
	    UserVO user2 = new UserVO(566, "ramesh", "hyd");
	    System.out.println("no. of users added:"+controller.addUser(user2));
	    UserVO user3 = new UserVO(128, "ram", "vzg");
	    System.out.println("no. of users added:"+controller.addUser(user3));
	    
	    UserVO user = controller.getUser(123);
	    user.setCity("vnk"); // update the city name vnm---> vnk
	    System.out.println("no. of users updated:"+controller.updateUser(user));
	    
	    
	    Set<UserVO> allusers = controller.getAllUsers();
	    System.out.println(allusers);
	    
	    
	    
	}

}
