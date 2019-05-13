package com.serialization.www;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonTest {

	public static void main(String[] args) throws Exception{
		Singleton singleton1 = Singleton.GetInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(singleton1);
        out.close();
         
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        System.out.println("Before Read");
        Singleton singleton2 = (Singleton) in.readObject();
        System.out.println("After Read");
        in.close();
         
        System.out.println("instanceOne hashCode="+singleton1.hashCode());
        System.out.println("instanceTwo hashCode="+singleton2.hashCode());
	}
}
