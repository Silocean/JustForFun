
public class Test������ {

	public static void main(String[] args) {
		//f1();
		f2();
	}
	/*
	 * ���ַ������ԣ�û���ų��ظ���ֵ
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
		System.out.println("���з��������������εĸ�����" + count);
	}
	/*
	 * ���ַ������������ε������������У��Ӷ���Ч�ر������ظ�
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
		System.out.println("���з��������������εĸ�����" + count);
	}

}
