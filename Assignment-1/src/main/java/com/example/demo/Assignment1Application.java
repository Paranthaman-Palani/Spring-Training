package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.InsufficientBalance;
import com.model.TransactionService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class Assignment1Application {

	public static void main(String[] args) throws InsufficientBalance {
		ConfigurableApplicationContext ctx = SpringApplication.run(Assignment1Application.class, args);	
		TransactionService tss = ctx.getBean("tss",TransactionService.class);			
		tss.moneyTransfer(2, 1, 200);	
	}
}
