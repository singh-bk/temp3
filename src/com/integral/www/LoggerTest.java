package com.integral.www;

import java.io.File;

public class LoggerTest {

	public static void main(String[] args){
		//Logger logger = new Logger();
		//logger.log("logger2.txt", "This is a first message\n");
		File file = new File("logger.txt");
		for(int i=0;i<100;i++)
		{
			String message = "This is message from Thread:"+i+"\n";
			Thread obj = new Thread(new LoggerImpl(message, file));
			obj.start();
		}
	}
}
