/*
 * ���³����ӡ��0~9�����֣��벹��ȱ�ٵĴ��롣
 */
public class Test�ݹ������� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		f(0, 9);
	}
	public static void f(int begin, int end)
	{
		if(begin == 10) return;
		System.out.println(begin);
		f(begin+1, end);	
	}

}
