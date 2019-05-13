package com.integral.www;

import java.util.LinkedList;
import java.util.List;

public class  ObjectPool<T> {

	 List<T> available = new LinkedList<T>();
	 List<T> inuse = new LinkedList<T>();
	 
	 public ObjectPool(T t){
		 
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 public synchronized Object getObject(){
		 if(!available.isEmpty()){			 
			 T obj = available.remove(0);
			 inuse.add(obj);
			 return obj;
		 }
		 else{
			 T obj = (T)new Object();
			 inuse.add(obj);
			 return obj;
		 }
	 }
	 
	 /**
	  * 
	  */
	 public synchronized void releaseObject(T obj){
		 available.add(obj);
		 inuse.remove(obj);
	 }
	 
	 /**
	 * @throws InterruptedException 
	  * 
	  */

	 public synchronized Object getObjectWithoutCreation() throws InterruptedException{
		 while(available.isEmpty()){
			 wait();
		 }	 
		 T obj = available.remove(0);
		 inuse.add(obj);
		 return obj;
	 }
}
