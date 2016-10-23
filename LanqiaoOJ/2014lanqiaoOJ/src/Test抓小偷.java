
public class Test抓小偷 {

	public static void main(String[] args) {
		for(int a=0; a<2; a++) {
			for(int b=0; b<2; b++) {
				for(int c=0; c<2; c++) {
					for(int d=0; d<2; d++) {
						if(a+b+c+d==3) {
							if(b+c!=2&&c+d!=2) {
								//System.out.println(a + " " + b + " " + c + " " + d);
								if(b==1) {
									System.out.println("C是小偷");
								}
								if(c==1) {
									System.out.println("D是小偷");
								}
							}
						}
					}
				}
			}
		}
	}

}
