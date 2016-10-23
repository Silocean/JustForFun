
public class Testºï×Ó³ÔÌÒ {

	public static void main(String[] args) {
		System.out.println(chiTao(1));
	}
	
	private static int chiTao(int day) {
		if(day==10) {
			return 1;
		} else {
			return (chiTao(day+1)+1)*2;
		}
	}

}
