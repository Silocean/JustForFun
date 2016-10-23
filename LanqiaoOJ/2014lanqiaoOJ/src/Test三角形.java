
public class Test三角形 {

	public static void main(String[] args) {
		//f1();
		f2();
	}
	/*
	 * 这种方法不对，没有排除重复的值
	 */
	private static void f1() {
		int count = 0;
		for(int i=3; i<=9; i++) {
			for(int j=3; j<=9; j++) {
				if(i == j) continue;
				for(int k=3; k<=9; k++) {
					if(i == k || j == k) continue;
					if((i+j)>k && (i+k)>j && (k+j)>i) {
						System.out.println(i + " " + j + " " + k);
						count ++;
					}
				}
			}
		}
		System.out.println("共有符合条件的三角形的个数：" + count);
	}
	/*
	 * 这种方法，把三角形的三边升序排列，从而有效地避免了重复
	 */
	private static void f2() {
		int count = 0;
		for(int i=3; i<=7; i++) {
			for(int j=i+1; j<=8; j++) {
				for(int k=j+1; k<=9; k++) {
					if((i+j)>k && (i+k)>j && (k+j)>i) {
						System.out.println(i + " " + j + " " + k);
						count ++;
					}
				}
			}
		}
		System.out.println("共有符合条件的三角形的个数：" + count);
	}

}
