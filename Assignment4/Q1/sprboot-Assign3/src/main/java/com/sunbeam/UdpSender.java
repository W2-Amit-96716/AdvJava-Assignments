package com.sunbeam;

import org.springframework.stereotype.Component;

//@Component
public class UdpSender implements Sender {

	public UdpSender() {
		
	}
	@Override
	public void send(double value) {
		System.out.println("Udp Sender: "+value);
	}

}
