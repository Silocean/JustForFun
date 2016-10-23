package À¶ÇÅÁ·Ï°;

public class »ØÎÄÊı {

	public static void main(String[] args) {
		for(int i=1000; i<=9999; i++) {
			int pre = i / 100;
			int lst = i % 100;
			if(pre / 10 == lst % 10 && pre % 10 == lst / 10) {
				System.out.println(i);
			}
		}
	}

}
