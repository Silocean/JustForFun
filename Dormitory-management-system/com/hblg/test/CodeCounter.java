package com.hblg.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {
	
	static long normalLines = 0;
	static long commentLines = 0;
	static long whiteLines = 0;

	public static void main(String[] args) {
		File f = new File("F:\\AllKindsOfWorkplace\\java workplace\\宿舍管理系统");
		tree(f);
		System.out.println("normalLines:" + normalLines);
		System.out.println("commentLines:" + commentLines);
		System.out.println("whiteLines:" + whiteLines);
		System.out.println("TOTAL LINES:" + (normalLines+commentLines+whiteLines));
	}
	
	private static void tree(File file) {
		File[] files = file.listFiles();
		for(int i=0; i<files.length; i++) {
			if(files[i].isDirectory()) {
				tree(files[i]);
			} else {
				if(files[i].getName().matches(".*\\.java$")) {
					parse(files[i]);
				}
			}
		}
	}
	
	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while((line = br.readLine()) != null) {
				line = line.trim();
				if(line.matches("^[\\s&&[^\\n]]*$")) {
					whiteLines ++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					commentLines ++;
					comment = true;	
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					commentLines ++;
				} else if (true == comment) {
					commentLines ++;
					if(line.endsWith("*/")) {
						comment = false;
					}
				} else if (line.startsWith("//")) {
					commentLines ++;
				} else {
					normalLines ++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
