/*
 * 以下程序打印出0~9的数字，请补充缺少的代码。
 */
public class Test递归找数字 {

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
