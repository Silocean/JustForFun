
public class Test找冠军 {

	public static void main(String[] args) {
		for(int a=0; a<2; a++) {
			for(int b=0; b<2; b++) {
				for(int c=0; c<2; c++) {
					for(int d=0; d<2; d++) {
						if((a==0&&d==0) || (a==0&&d==1) || (a==1&&d==0) || (a==1&&c==1) || (b==1&&c==0) || (b==1&&d==1)) {
							continue;
						}
						// System.out.println(a + " " + b + " " + c + "  " + d);
						if(a==0) System.out.println("乙获铅球冠军");
						if(a==1) System.out.println("丁获跳高冠军");
						if(b==0) System.out.println("甲获百米冠军");
						if(b==1) System.out.println("戊获跳远冠军");
						if(c==0) System.out.println("丙获跳远冠军");
						if(c==1) System.out.println("丁获二百米冠军");
						if(d==0) System.out.println("乙获跳高冠军");
						if(d==1) System.out.println("戊获铅球冠军");
						
					}
				}
			}
		}
	}

}
