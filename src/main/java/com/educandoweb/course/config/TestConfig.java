package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entites.Category;
import com.educandoweb.course.entites.Order;
import com.educandoweb.course.entites.User;
import com.educandoweb.course.entites.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
       
	   @Autowired
	   private UserRepository userRepositry;
	   @Autowired
	   private OrderRepository orderRepository;
	   @Autowired
	   private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category c = new Category(null,"Eletronics");
		Category c2 = new Category(null,"Books");
		Category c3 = new Category(null,"Computers");
		
		
		
		User u1 = new User( "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User( "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order( null,Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERED, u2);
		Order o3 = new Order( null,Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		userRepositry.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		categoryRepository.saveAll(Arrays.asList(c,c2,c3));
	}

}
