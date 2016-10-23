package com.hblg.test;

public class TestRegexp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String str = "65";
		if(str.matches("[\\d]+")) {
			System.out.println(true);
		}*/
		/*String str = "201140420101";
		System.out.println(str.matches("2011\\d{8}"));*/
		/*String str = "2011-09-1";
		System.out.println(str.matches("\\d{4}-\\d{1,2}-\\d{1,2}"));*/
		/*String str = "2011-9-1 21:12:4";
		System.out.println(str.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}"));*/
		/*String str = "325245.26";
		System.out.println(str.matches("\\d*.\\d*"));*/
		String str = "µÄ";
		System.out.println(str.matches("[^x00-xff]"));
	}

}
