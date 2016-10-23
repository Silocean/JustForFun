/*
 * 把一个串从数字不连续的位置断开
 */
public class Test不连续处断开 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12345234568923456789";
		String t = s.charAt(0)+"";
		for(int i=1; i<s.length(); i++)
		{
			if(s.charAt(i)==s.charAt(i-1)+1)
			{
				t += s.charAt(i);
			}	
			else
			{
				System.out.println(t);
				t = s.charAt(i)+"";
			}		
		}
		System.out.println(t);
	}

}
