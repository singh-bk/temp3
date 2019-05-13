package com.hp.util;

import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) throws Exception
	{
		//String message = "Bill Dated 31-MAR-2013 is due on 31-MAY-2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31 MAR 2013 is due on 31 MAY 2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31.MAR.2013 is due on 07.Jun.2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31/MAR/2013 is due on 01/Jun/2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31/03/2013 is due on 01/06/2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31/3/2013 is due on 11/6/13.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31 3 2013 is due on 01 6 13.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31 3 2013 is due on 01 6.Total Bill Amout=Rs.1234.56.";
		//String message = "Dear Customer you have made a debit card purchase of INR2,190 on 21 Aug.Info. VPS*FORTIS HOSP."; 
		//String message = "Rs. 1,55,425.62 was spent on your Credit Card 5546xxxxxxxx1460 on 21-07 at SHOPPERS STOP.";
		String message = "Rs. 1,55,425.62 was spent on your Credit Card 5546xxxxxxxx1460 on 13Aug at SHOPPERS STOP.";
		Calendar billduedate = GetDueDateCalendarFromMessage(message);
		if(billduedate != null)
			System.out.println("In Main Method:"+billduedate.getTime());
		else
			System.out.println("Bill Due Date is null");
	}
	
    /**
     * @param message
     *          The sms received by the phone
     * @return  Calendar
     *          A Calendar object containg the bill due date.
     */
    private static Calendar GetDueDateCalendarFromMessage(String message)
    {
    	String[] pattern = new String[3];
        //To check for patterns like 03-MAR-2013
        pattern[0] = new String("\\d{1,2}[-./\\ ]{1}[a-zA-Z]{3}[-./\\ ]{1}\\d{2,4}");
        //To check for patterns like 03-03-2013
        pattern[1] = new String("\\d{1,2}[-./\\ ]{1}\\d{1,2}[-./\\ ]{1}\\d{2,4}");
        pattern[2] = new String("\\d{1,2}[-]{1}\\d{1,2}");
        //pattern[3] = new String("\\d{1,2}[-./\\ ]{1}[a-zA-Z]{3}");

        Calendar billDueDate = null;
        for(int i=0; i< pattern.length; i++)
        {
        	billDueDate = MatchPattern(pattern[i], message);
        	if(billDueDate != null)
        	{
        		System.out.println("Bill Due Date:"+billDueDate.getTime());
        		break;
        	}
        }
        if(billDueDate == null)
        {
        	System.out.println("Bill Date was null");
        	String[] patternNew = new String[1];
        	patternNew[0] = new String("\\d{1,2}[- ]{0,1}[a-zA-Z]{3}");
        	billDueDate = MatchPatternNew(patternNew[0], message);
        }
        return billDueDate;
    }

    private static Calendar MatchPattern(String pattern, String message)
    {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(message);
        int count = 0;
        Calendar today = Calendar.getInstance();
        Calendar dueDate = today;
        Calendar billDueDate = null;
        /*
         * A message can contain 2 dates. Bill preparation date and Bill Due Date.
         * Bill preparation date will always be before the current date.
         * Bill Due Date will always be after the current date.
         * Iterate over all the dates and find the date that lies after the current date
         */
        while(matcher.find())
        {
            String dateStr = matcher.group(count);
            dueDate = GetDueDate(dateStr);
            if(dueDate.compareTo(today)>0)
                billDueDate = dueDate;
        }
        return billDueDate;
    }

    private static Calendar MatchPatternNew(String pattern, String message)
    {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(message);
        int count = 0;
        Calendar today = Calendar.getInstance();
        Calendar dueDate = today;
        /*
         * A message can contain 2 dates. Bill preparation date and Bill Due Date.
         * Bill preparation date will always be before the current date.
         * Bill Due Date will always be after the current date.
         * Iterate over all the dates and find the date that lies after the current date
         */
        while(matcher.find())
        {
            String dateStr = matcher.group(count);
            dueDate = GetBillDate(dateStr);
        }
        return dueDate;
    }
    
    /**
     * @param dateStr
     * @return
     */
    private static Calendar GetDueDate(String dateStr)
    {
    	System.out.println("Date Str:"+dateStr);
        StringTokenizer token = null;
        int date = -1;
        int month = -1;
        int year = -1;
        String monthStr = null;
        Calendar dueDate = Calendar.getInstance();
        if(dateStr.contains("-"))
        {
            token = new StringTokenizer(dateStr,"-");
        }
        else if(dateStr.contains("."))
        {
            token = new StringTokenizer(dateStr,".");
        }
        else if(dateStr.contains("/"))
        {
            token = new StringTokenizer(dateStr,"/");
        }
        else if(dateStr.contains("\\"))
        {
            token = new StringTokenizer(dateStr,"\\");
        }   
        else if(dateStr.contains(" "))
        {
            token = new StringTokenizer(dateStr," ");
        }       
        int tokenCount = token.countTokens();
        int count=0;
        while(token!= null && token.hasMoreTokens())
        {
            date=Integer.parseInt(token.nextToken());
            count++;
            monthStr = token.nextToken();
            try
            {
                //subtract 1 from month to make it compatible with Calendar API
                month=Integer.parseInt(monthStr)-1;
                count++;
            }
            catch(NumberFormatException nfex)
            {
                month=GetMonth(monthStr);
                count++;
            }
            if(count == tokenCount)
            {
            	year = dueDate.get(Calendar.YEAR);
            }
            else
            {
            	year=Integer.parseInt(token.nextToken());
            }
            // if the year is in yy format change it to yyyy format
            if(year<100)
                year = year+2000;            
        }
        // create the calendar event 2 days prior to the due date.
        dueDate.set(year, month, date-2, 9, 0, 0);
        return dueDate;
    }

    private static Calendar GetBillDate(String dateStr)
    {
    	System.out.println("Bill Date Str:"+dateStr);
    	String monthStr = CheckIfDate(dateStr);
    	if(monthStr == null){
    		return null;
    	}
    	else
    	{
    		int month = GetMonth(monthStr);
    		String billDateStr = dateStr.substring(0,dateStr.indexOf(monthStr));
    		int billDate = Integer.parseInt(billDateStr.trim());
    		System.out.println(billDate+" "+month);
    		Calendar billDateCal = Calendar.getInstance();
    		billDateCal.set(billDateCal.get(Calendar.YEAR), month, billDate);
    		return billDateCal;
    	}
    }

    public static String CheckIfDate(String dateStr)
    {
    	String monthStr = null;
    	if(dateStr.toUpperCase().contains("JAN"))
    		monthStr = "Jan";
    	if(dateStr.toUpperCase().contains("FEB"))
    		monthStr = "Feb";
    	if(dateStr.toUpperCase().contains("MAR"))
    		monthStr = "Mar";
    	if(dateStr.toUpperCase().contains("APR"))
    		monthStr = "Apr";
    	if(dateStr.toUpperCase().contains("MAY"))
    		monthStr = "May";
    	if(dateStr.toUpperCase().contains("JUN"))
    		monthStr = "Jun";
    	if(dateStr.toUpperCase().contains("JUL"))
    		monthStr = "Jul";
    	if(dateStr.toUpperCase().contains("AUG"))
    		monthStr = "Aug";
    	if(dateStr.toUpperCase().contains("SEP"))
    		monthStr = "Sep";
    	if(dateStr.toUpperCase().contains("OCT"))
    		monthStr = "Oct";
    	if(dateStr.toUpperCase().contains("NOV"))
    		monthStr = "Nov";
    	if(dateStr.toUpperCase().contains("DEC"))
    		monthStr = "Dec";
    	return monthStr;
    }
    
    /**
     * @param monthStr
     *          Month as a String
     * @return integer representation of the month.
     *          Ex: 0 for Jan, etc
     */
    private static int GetMonth(String monthStr)
    {
        int month = -1;
        if(monthStr.equalsIgnoreCase("Jan") || monthStr.equalsIgnoreCase("January"))
            month=0;
        else  if(monthStr.equalsIgnoreCase("Feb") || monthStr.equalsIgnoreCase("February"))
            month=1;
        else  if(monthStr.equalsIgnoreCase("Mar") || monthStr.equalsIgnoreCase("March"))
            month=2;
        else  if(monthStr.equalsIgnoreCase("Apr") || monthStr.equalsIgnoreCase("April"))
            month=3;
        else  if(monthStr.equalsIgnoreCase("May"))
            month=4;
        else  if(monthStr.equalsIgnoreCase("Jun") || monthStr.equalsIgnoreCase("June"))
            month=5;
        else  if(monthStr.equalsIgnoreCase("Jul") || monthStr.equalsIgnoreCase("July"))
            month=6;
        else  if(monthStr.equalsIgnoreCase("Aug") || monthStr.equalsIgnoreCase("August"))
            month=7;
        else  if(monthStr.equalsIgnoreCase("Sep") || monthStr.equalsIgnoreCase("September"))
            month=8;
        else  if(monthStr.equalsIgnoreCase("Oct") || monthStr.equalsIgnoreCase("October"))
            month=9;
        else  if(monthStr.equalsIgnoreCase("Nov") || monthStr.equalsIgnoreCase("November"))
            month=10;
        else  if(monthStr.equalsIgnoreCase("Dec") || monthStr.equalsIgnoreCase("December"))
            month=11;
        return month;
    }
}
