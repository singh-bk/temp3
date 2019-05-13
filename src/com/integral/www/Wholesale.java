package com.integral.www;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Wholesale {

	Map<String, LinkedList<Vendor>> prdVendorMap = new HashMap<String, LinkedList<Vendor>>();
	Map<String, LinkedList<Customer>> prdCustMap = new HashMap<String, LinkedList<Customer>>();
	Map<String, Integer> prdPriceMap = new HashMap<String, Integer>();
	
	private Wholesale instance = new Wholesale();
	
	private Wholesale(){};
	
	public Wholesale getInstance()
	{
		return this.instance;
	}
	
	public void subscribeCustomerToAProduct(Customer cust, String prdId)
	{
		LinkedList<Customer> custList = prdCustMap.get(prdId);
		if(custList != null)
		{
			custList.add(cust);
		}
		else
		{
			custList = new LinkedList<Customer>();
			custList.add(cust);
		}
		prdCustMap.put(prdId, custList);
	}
	
	public void unsubscribeCustomerFromAProduct(Customer cust, String prdId)
	{
		LinkedList<Customer> custList = prdCustMap.get(prdId);
		if(custList != null)
		{
			custList.remove(cust);
		}
		prdCustMap.put(prdId, custList);
	}
	
	public void addVendorForAProduct(Vendor vendor, String prdId)
	{
		LinkedList<Vendor> vendorList = prdVendorMap.get(prdId);
		if(vendorList != null)
		{
			vendorList.add(vendor);
		}
		else
		{
			vendorList = new LinkedList<Vendor>();
			vendorList.add(vendor);
		}
		prdVendorMap.put(prdId, vendorList);
	}
	
	public void removeVendorForAProduct(Vendor vendor, String prdId)
	{
		LinkedList<Vendor> vendorList = prdVendorMap.get(prdId);
		if(vendorList != null)
		{
			vendorList.remove(vendor);
		}
		prdVendorMap.put(prdId, vendorList);
	}
	
	public void notifyOnChangeOfPrice(Vendor vendor, String prdId, int newPrice)
	{
		
	}
}	
