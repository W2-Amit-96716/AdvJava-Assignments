package com.sunbeam;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.stereotype.Component;
@Component
public class FileLoggerImpl implements Logger{
	private String logFilePath;
	
	public FileLoggerImpl() {
		this.logFilePath="applog.txt";
	}
	
	public String getLogFilePath() {
		return logFilePath;
		
	}
	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}
	
	@Override
	public void log(String massage) {
		System.out.println("FILE: "+ massage);
		try(FileOutputStream fout = new FileOutputStream(logFilePath, true)){
			try(PrintStream pout = new PrintStream(fout)){
				pout.println(massage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
