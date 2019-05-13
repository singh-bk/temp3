package com.hp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmountPatternMatcher {
	public static void main(String[] args) throws Exception
	{

		//String message = "Bill Dated 31-03-2013 is due on 01 6.Total Bill Amout=Rs. 0.56.";
		//String message = "Rs. 1,55,425.62 was spent on your Credit Card 5546xxxxxxxx1459 on 13-JUL-13 at SHOPPERS STOP.";
		String message = "Rs. 0.62 was spent on your Credit Card 5546xxxxxxxx1459 on 13-JUL-13 at SHOPPERS STOP.";
		String amountSpent = GetAmountFromMessage(message);
		String cardNumber = GetCardNumberFromMessage(message);
		String storeName = GetStoreNameFromMessage(message);
		if(amountSpent != null)
			System.out.println("In Main Method:"+amountSpent);
		else
			System.out.println("Amount Spent is not found");
		
		System.out.println("Card Number:"+cardNumber);
	}
	

    /**
     * @param message
     * @return
     */
    private static String GetAmountFromMessage(String message)
    {
    	String[] pattern = new String[1];
        
        pattern[0] = "\\d{0,3}[,]{0,1}\\d{0,3}[,]{0,1}\\d{1,15}[.]{1}\\d{2}";

        String amountSpent = null;
        for(int i=0; i< pattern.length; i++)
        {
        	amountSpent = MatchPattern(pattern[i], message);
        	if(amountSpent != null)
        	{
        		System.out.println("Bill Due Date:"+amountSpent);
        		break;
        	}
        }
        return amountSpent;
    }
    
    /**
     * @param message
     * @return
     */
    private static String GetCardNumberFromMessage(String message)
    {
    	String[] pattern = new String[1];
        
        pattern[0] = "\\d{0,4}[Xx*]{8,12}\\d{4}";

        String amountSpent = null;
        for(int i=0; i< pattern.length; i++)
        {
        	amountSpent = MatchPattern(pattern[i], message);
        	if(amountSpent != null)
        	{
        		System.out.println("Card Number:"+amountSpent);
        		break;
        	}
        }
        return amountSpent;
    }
    
    private static String GetStoreNameFromMessage(String message)
    {
    	String storeName = null;
    	return storeName;
    }
    
    private static String MatchPattern(String pattern, String message)
    {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(message);
        int count = 0;
        String amountSpent = null;
        /*
         * A message can contain 2 dates. Bill preparation date and Bill Due Date.
         * Bill preparation date will always be before the current date.
         * Bill Due Date will always be after the current date.
         * Iterate over all the dates and find the date that lies after the current date
         */
        while(matcher.find())
        {
            String amountSpentStr = matcher.group(count);
            System.out.println("Card Number:"+amountSpentStr);
            amountSpent = amountSpentStr;
        }
        return amountSpent;
    }
}
