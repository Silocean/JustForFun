package com.hblg.common;

import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hblg.view.LoginFrame;

public class Tools {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ HH:mm:ss");
	
	public static Image img = Toolkit.getDefaultToolkit().getImage(
			LoginFrame.class.getClassLoader().getResource("images/icon.png"));
	
	public static String convertToString(Date date) {
		return sdf.format(date);
	}
	
	public static Date convertToDate(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
