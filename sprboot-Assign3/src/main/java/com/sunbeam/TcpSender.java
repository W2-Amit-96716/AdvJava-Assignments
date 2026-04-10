package com.sunbeam;

import org.springframework.stereotype.Component;

//@Primary
//@Component
public class TcpSender implements Sender{
	
	public TcpSender() {
		
	}
	public TcpSender(double value) {
		System.out.println("TcpSender method ");
		
	}
	@Override
	public void send(double value) {
		System.out.println("TCP sender : "+value);
	}
	
}
