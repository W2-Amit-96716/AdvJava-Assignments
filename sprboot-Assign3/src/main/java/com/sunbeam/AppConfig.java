package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@ComponentScan("com.sunbeam")

@Configuration
public class AppConfig {
	
	@Bean
	@Primary
	public Sender tcpSender() { 
		return new TcpSender(); 
		}
	
	@Bean
	public Sender httpSender() {
		return new HttpSender();
	}
	
	@Bean
	public Sender udpSender() {
		return new UdpSender();
	}
	
}
