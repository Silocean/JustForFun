import java.util.Calendar;


public class Test¹úÇìĞÇÆÚ¼¸ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		int count = 0;
		for(int i=1949; i<=2012; i++) {
			c.set(i, 9, 1);
			if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count ++;
				System.out.println(i);
			}
		}
		System.out.println(count);
//		c.setTime(new Date());
//		c.set(1900, 0, 1);
//		System.out.println(c.get(Calendar.DAY_OF_WEEK)-1);
	}

}
