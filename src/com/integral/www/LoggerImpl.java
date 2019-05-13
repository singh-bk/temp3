package com.integral.www;

import java.io.File;

public class LoggerImpl implements Runnable{

	String message = "";
	File file;
	public LoggerImpl(String message, File file)
	{
		this.message = message;
		this.file = file;
	}
	@Override
	public void run() {
			Logger logger = new Logger();
			logger.log(file, this.message);
	}

}
