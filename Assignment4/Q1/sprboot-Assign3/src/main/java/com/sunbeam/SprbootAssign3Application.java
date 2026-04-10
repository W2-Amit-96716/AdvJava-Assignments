package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class SprbootAssign3Application implements CommandLineRunner{

    private final AppConfig appConfig;
	
	SprbootAssign3Application(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
	public static void main(String[] args) {
		SpringApplication.run(SprbootAssign3Application.class, args);
	}
	
	
	@Autowired ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		
		ctx.getBean(TcpSender.class).send(10.5);;
		System.out.println("TcpSender called..");
		
		ctx.getBean(HttpSender.class).send(15.7);
		System.out.println("HttpSender called..");
		
		ctx.getBean(UdpSender.class).send(85.7);
		System.out.println("UdpSender called..");
		
		ctx.getBean(Sender.class).send(56.54);
		System.out.println("Called through Sender...I have Set the tcpSender as a @Primary Bean ");
	}
}
