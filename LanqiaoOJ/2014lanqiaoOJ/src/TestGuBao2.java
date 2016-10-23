public class TestGuBao2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 10; b++) {
				if(a==b) continue;
				for (int c = 0; c < 10; c++) {
					if(a==c || b==c) continue;
					for(int d=0; d<10; d++) {
						if(d==a || d==b || d==c) continue;
						for(int e=0; e<10; e++) {
							if(e==a) {
								for(int f=0; f<10; f++) {
									if(f==a || f==b || f==c || f==d || f==e) continue;
									if((a*100+b*10+c) * (d*10+e) == (b*1000+c*100+d*10+f)) {
										System.out.println(""+a+b+c + "*" + d+a + "=" + b+c+d+f);
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
