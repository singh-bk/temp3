package com.custom.api;

public class HashMap implements Map {

	Map.Entry[] bucket = new Map.Entry[100];
	
	/**
	 * Calculate the hashvalue of the key;
	 * If the Map.Entry element in the bucket with index hashvalue is null
	 * 		create a new Map.Entry element with key, value and add it to bucket[hashvalue]
	 * else
	 * 		iterate to the end of the list and add the element over there.
	 */
	@Override
	public void put(String key, String value) {
		int hash = calculateHashVal(key);
		if(bucket[hash] == null){
			bucket[hash] = new Map.Entry(key, value);
		}
		else{
			Map.Entry entry = bucket[hash];
			while(entry.getNext() != null){
				entry = entry.getNext();
			}
			Map.Entry next = new Map.Entry(key, value);
			entry.setNext(next);
		}
	}

	/**
	 * get the hashvalue of key
	 * look for the presence of key in bucket[hashvalue]
	 */
	@Override
	public String get(String key) {
		int hash = calculateHashVal(key);
		if(bucket[hash] == null){
			return null;
		}
		else{
			String value = null;
			Map.Entry entry = bucket[hash];
			while(entry != null){
				if(entry.getKey().equals(key)){
					value = entry.getValue();
					break;
				}
				else{
					entry = entry.getNext();
				}
			}
			return value;
				
		}
	}
	
	/**
	 * Method to calculate the hashval of the map based on default algo
	 * @param str
	 * @return
	 */
	private int calculateHashVal(String str){
		int hash = 0;
		char[] strArr = str.toCharArray();
		for(int i=0;i<strArr.length;i++){
			hash = hash+(int)strArr[i];
		}
		return hash%100;
	}

}
