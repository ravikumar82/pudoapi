package utils;

import java.text.DateFormatSymbols;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class FormatDayAndHours implements Callable {
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		FormatDayAndHours obj = new FormatDayAndHours();
         obj.formatWeekDay(1);
		return obj;
	}
	
	public static String formatWeekDay(int day) {
		DateFormatSymbols dfs = new DateFormatSymbols();
	     return dfs.getWeekdays()[day]; 
		
	}
}





