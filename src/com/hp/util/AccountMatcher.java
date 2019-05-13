package com.hp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountMatcher {

	public static void main(String[] args){
		//String message = "HSBC: Your Account 071-052***-006 has been debited with INR3,300.00 on 29Aug as Cash Withdrwal";
		//String message = "HSBC: Your Account 071-052-223-006 has been debited with INR3,300.00 on 29Aug as Cash Withdrwal";
		String message = "HSBC: Your Account 071052223006 has been debited with INR3,300.00 on 29Aug as Cash Withdrwal";
		String match = GetAccountNumberFromMessage(message);
		System.out.println(match);
	}
	
    /**
     * @param message
     *          The sms received by the phone
     * @return  Calendar
     *          A Calendar object containg the bill due date.
     */
    private static String GetAccountNumberFromMessage(String message)
    {
    	String[] pattern = new String[1];
        //To check for patterns like 03-MAR-2013
        pattern[0] = new String("[0-9\\-\\*]{12,20}");
        String accountNumber = null;
        for(int i=0; i< pattern.length; i++)
        {
        	accountNumber = MatchPattern(pattern[i], message);
        	if(accountNumber != null)
        	{
        		System.out.println("Bill Due Date:"+accountNumber);
        		break;
        	}
        }
        return accountNumber;
    }
    
    private static String MatchPattern(String pattern, String message)
    {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(message);
        int count = 0;
        String match = null;
        while(matcher.find())
        {
            match = matcher.group(count);
        }
        return match;
    }

}
