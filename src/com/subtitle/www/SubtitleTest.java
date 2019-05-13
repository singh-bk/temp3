package com.subtitle.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class SubtitleTest {

	public static void main(String[] args) throws Exception{
		
		int lag = 6;
		File file = new File("Fargo.S03E04.HDTV.SVA.en.srt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		File op = new File("Fargo.S03E04.HDTV.SVA.en2.srt");
		op.createNewFile();
		FileWriter fw = new FileWriter(op);
		String line = "";
		
		while((line = br.readLine()) != null){
			System.out.println(line);
			
			if(line.contains("-->")){
				StringTokenizer tokens = new StringTokenizer(line, " --> ");
				String start = tokens.nextToken().trim();
				StringTokenizer startTokens = new StringTokenizer(start, ",");
				String start11 = changed(startTokens.nextToken(), lag);
				String start22 = startTokens.nextToken();
				
				String end = tokens.nextToken();
				
				StringTokenizer endTokens = new StringTokenizer(end, ",");
				String end11 = changed(endTokens.nextToken(),lag).trim();
				String end22 = endTokens.nextToken();
				
				String changedStr = start11+","+start22+" --> "+end11+","+end22;
				
				fw.write(changedStr);
				fw.write("\n");
			}else{
				fw.write(line);
				fw.write("\n");
			}
		}
		
		br.close();
		fr.close();
		fw.close();
	}
	
	public  static String changed(String data, int lag){
		//System.out.println(data);
		StringTokenizer tokens = new StringTokenizer(data, ":");
		String hh = tokens.nextToken();
		String mm = tokens.nextToken();
		String ss = tokens.nextToken();
		
		int sss = Integer.parseInt(ss);
		int mmm = Integer.parseInt(mm);
		int hhh = Integer.parseInt(hh);
		sss = sss + lag;
		if(sss >= 60){ 
			sss = sss -60;
			mmm++;
			if(mmm >= 60){
				mmm = mmm-60;
				hhh++;
			}
		}
		if(sss <10){
			ss = "0"+sss;
		}
		else{
			ss = sss+"";
		}
		
		if(mmm < 10){
			mm = "0"+mmm;
		}else{
			mm = mmm+"";
		}
		
		if(hhh < 10){
			hh = "0"+hhh;
		}else{
			hh = hhh+"";
		}
		
		return hh+":"+mm+":"+ss;
	}
}
