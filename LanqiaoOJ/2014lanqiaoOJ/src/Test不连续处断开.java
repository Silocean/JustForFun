/*
 * ��һ���������ֲ�������λ�öϿ�
 */
public class Test���������Ͽ� {

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
