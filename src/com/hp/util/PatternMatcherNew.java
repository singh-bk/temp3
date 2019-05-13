package com.hp.util;

import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherNew {

	public static void main(String[] args)
	{
		//String message = "Bill Dated 31-MAR-2013 is due on 31-MAY-2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31 MAR 2013 is due on 31 MAY 2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31.MAR.2013 is due on 01.Jun.2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31/MAR/2013 is due on 01/Jun/2013.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31/03/2013 is due on 01/06/2013.Total Bill Amout=Rs.1234.56.";
		String message = "Bill Dated 31/3/2013 is due on 01/6/13.Total Bill Amout=Rs.1234.56.";
		//String message = "Bill Dated 31 3 2013 is due on 01 6 13.Total Bill Amout=Rs.1234.56.";
		Calendar dueDateCal = GetDueDateCalendarFromMessage(message);
	}
	
    private static Calendar GetDueDateCalendarFromMessage(String message)
    {
        String pattern = "\\d{1,2}[-./\\ ]{1}[a-zA-Z]{3}[-./\\ ]{1}\\d{2,4}";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(message);
        int count = 0;

        Calendar billDueDate = null;
        Calendar today = Calendar.getInstance();
        Calendar dueDate = today;

        //Date today = new Date();
        while(matcher.find())
        {
            String dateStr = matcher.group(count);
            dueDate = GetDueDate(dateStr);
        }
        if(dueDate.compareTo(today)>0)
        {
            billDueDate = dueDate;
        }
        if(billDueDate == null)
        {
            System.out.println("Bill Due Date IS NULL. Use the other pattern");
            String pattern2 = "\\d{1,2}[-./\\ ]{1}\\d{1,2}[-./\\ ]{1}\\d{2,4}";
            Pattern regex2 = Pattern.compile(pattern2);
            Matcher matcher2 = regex2.matcher(message);
            while(matcher2.find())
            {
                String dateStr = matcher2.group(count);
                dueDate = GetDueDate(dateStr);
            }
            if(dueDate.compareTo(today)>0)
            {
                billDueDate = dueDate;
            }
        }

        if(billDueDate != null)
            System.out.println("Bill Due Date:"+billDueDate.getTime());
        return billDueDate;
    }
    
    private static Calendar GetDueDate(String dateStr)
    {
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
        while(token!= null && token.hasMoreTokens())
        {
            date=Integer.parseInt(token.nextToken());
            monthStr = token.nextToken();
            try
            {
                month=Integer.parseInt(monthStr)-1;
            }
            catch(NumberFormatException nfex)
            {
                month=GetMonth(monthStr);
            }
            year=Integer.parseInt(token.nextToken());
        }
        // create the calendar event 2 days prior to the due date.
        dueDate.set(year, month, date-2, 9, 0, 0);
        return dueDate;
    }
    
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
