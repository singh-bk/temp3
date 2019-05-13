package com.integral.www;

import java.io.File;

public interface Log {

	//public void log(String filename, String message);
	public void log(File file, String message);
}
