
public class TestSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		
		System.out.println(swap(a, b)[0] + " " + swap(a, b)[1]);
	}
	
	public static Integer[] swap(Integer a, Integer b) {
		Integer temp;
		temp = a;
		a = b;
		b = temp;
		Integer[] numbers = {a, b};
		return numbers;
	}

}
