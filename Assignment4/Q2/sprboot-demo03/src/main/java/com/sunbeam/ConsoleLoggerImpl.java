package com.sunbeam;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class ConsoleLoggerImpl implements Logger {
	@Override
	public void log(String massage) {
		System.out.println("CONSOLE: "+ massage);
	}
}
