package com.ilabs.interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

	public static void main(String[] args) throws Exception{
		SerializableClass obj = new SerializableClass();
		obj.setAge(30);
		obj.setName("BK");
		obj.setCompany("HP");
		obj.staticVar = 100;
		
		FileOutputStream fos = new FileOutputStream("stream");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		
		FileInputStream fis = new FileInputStream("stream");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerializableClass obj2 = (SerializableClass)ois.readObject();
		System.out.println(obj2.getAge()+" "+obj2.getName()+" "+obj2.getCompany()
				+" "+obj2.getSerialversionuid()+" "+obj2.StaticMethod());
		obj2.setName("AS");
		System.out.println("New Name:"+obj.getName());
	}
}
