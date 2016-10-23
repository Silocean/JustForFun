
public class TestGuBao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		for(int a=0; a<=9; a++) {
			for(int b=0; b<=9; b++) {
				if(b == a) continue;
				for(int c=0; c<=9; c++) {
					if(c == b || c == a) continue;
					for(int d=0; d<=9; d++) {
						if(d == c || d == b || d == a) continue;
						for(int e=0; e<=9; e++) {
							if(e == d || e == c || e == b || e == a) continue;
							num = a*10000+b*1000+c*100+d*10+e;
							for(int i=0; i<=9; i++) {
								if(num*i == e*10000+d*1000+c*100+b*10+a) {
									System.out.println(num + " " + i);
								}
							}
						}
					}
				}
			}
		}
	}

}
