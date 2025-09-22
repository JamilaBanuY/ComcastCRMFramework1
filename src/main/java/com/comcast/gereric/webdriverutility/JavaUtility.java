package com.comcast.gereric.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random ranDom = new Random();
		int Rnum = ranDom.nextInt(5000);
		return Rnum;
	}

	public String getSystemDate()
	{
	Date dateObj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//String date = sdf.format(dateObj);
	return  sdf.format(dateObj);
	
	}

public String getRequiredDate(int days)
	{
		Date dateObj=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(dateObj);
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		//Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		//String reqDate = sim.format(cal.getTime());
		return  sim.format(cal.getTime());
		
		
		/*Date dateObj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(dateObj);
	Calendar cal=sdf.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate = sdf.format(cal.getTime());
	return reqDate;*/
		
	}
	
}
