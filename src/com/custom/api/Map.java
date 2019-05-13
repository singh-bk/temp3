package com.custom.api;


public interface Map {

	public void put(String key, String value);
	
	public String get(String key);
	
	public class Entry{
		private String key;
		private String value;
		private Map.Entry next;
		private Map.Entry prev;
		
		public Entry(String key, String value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
		public Entry(String key, String value, Map.Entry prev){
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = prev;
		}
		
		public String getKey(){
			return this.key;
		}
		
		public String getValue(){
			return this.value;
		}
		
		public Map.Entry getNext(){
			return this.next;
		}
		
		public void setNext(Map.Entry next){
			this.next = next;
		}
		
		public Map.Entry getPrev(){
			return this.prev;
		}
		
		public void setPrev(Map.Entry prev){
			this.prev = prev;
		}
	}
}
