package utils;

import java.text.DateFormatSymbols;

public class MyUtils {
	
	public static String formatWeekDay(int day) {
		DateFormatSymbols dfs = new DateFormatSymbols();
	     return dfs.getWeekdays()[day]; 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUtils mu =new MyUtils();
		
	        System.out.println(mu.formatWeekDay(1));

	}

}
