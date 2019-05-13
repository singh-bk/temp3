package com.integral.www;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements Log{

	/*
	@Override
	public void log(String filename, String message) {
		try {
			System.out.println(message);
			final File file = new File(filename);
			synchronized (file) {
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(message);
				bw.close();
				fw.close();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	@Override
	public void log(File file, String message) {
		try {
				synchronized (file) {
					System.out.print(message);
					FileWriter fw = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(message);
					bw.close();
					fw.close();
					file.notifyAll();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
