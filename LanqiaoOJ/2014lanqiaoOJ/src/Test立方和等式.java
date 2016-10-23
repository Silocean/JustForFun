
public class Test立方和等式 {

	public static void main(String[] args) {
		for(int a=1; a<27; a++) {
			for(int b=a+1; b<28; b++) {
				for(int c=b+1; c<29; c++) {
					for(int d=c+1; d<30; d++) {
						if(((a*a*a)+(d*d*d)) == ((c*c*c)+(b*b*b))) {
							System.out.print(a + "," + b + "," + c + "," + d);
							System.out.println();
						}
					}
				}
			}
		}
	}

}
