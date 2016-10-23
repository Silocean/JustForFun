package com.hblg.test;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.hblg.view.LoginFrame;

public class Run {

	/**
	 * @author SilenceOcean
	 */
	public static void main(String[] args) {
		InitGlobalFont(new Font("������Ů����W5(P)", java.awt.Font.PLAIN, 14));
		new LoginFrame();
	}
	
	/*
	 * ���Ľ���Ĭ���������
	 */
	private static void InitGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}
}
