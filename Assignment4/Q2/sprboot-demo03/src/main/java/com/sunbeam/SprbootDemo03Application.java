package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.sunbeam.Account;
import com.sunbeam.AppConfig;
import com.sunbeam.ConsoleLoggerImpl;
import com.sunbeam.FileLoggerImpl;
import com.sunbeam.Logger;

@Import(AppConfig.class)

@SpringBootApplication
public class SprbootDemo03Application implements CommandLineRunner{

	
	
	public static void main(String[] args) {
		SpringApplication.run(SprbootDemo03Application.class, args);
	
	}
	@Autowired
	private ApplicationContext ctx;
	public void run(String... args) throws Exception {
		Logger consoleLogger = ctx.getBean(ConsoleLoggerImpl.class);
		consoleLogger.log("Log Massage 1");
		
		Logger fileLogger = ctx.getBean(FileLoggerImpl.class);
		fileLogger.log("Log Massage 2");
		
		Account acc = ctx.getBean(Account.class);
		acc.setLogger(consoleLogger);
		acc.setLogger(fileLogger);
		//acc.setLogger(logger);
		
		System.out.println("acc -- " + acc); // 40000
		acc.deposit(4000);
		System.out.println("acc -- " + acc); // 44000
		acc.whithdraw(3000);
		System.out.println("acc -- " + acc); 
	}

}
