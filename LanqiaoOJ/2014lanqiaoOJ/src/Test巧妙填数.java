
public class Test�������� {

	public static void main(String[] args) {
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=9; j++) {
				if(i==j) continue;
				for(int k=1; k<=9; k++) {
					if(k==j && k==i) continue;
					int num = i*100 + j*10 + k;
					if(num*3<1000) {
						// ��֤������1~9����Ҳ��ظ�
						if((sum(num) + sum(num*2) + sum(num*3) == 45) && (mul(num)*mul(num*2)*mul(num*3) == 362880)) {
							System.out.println(num);
							System.out.println(num*2);
							System.out.println(num*3);
							System.out.println("===================");
						}
					}
				}
			}
		}
	}
	
	/*
	 * ��λ����λ֮��
	 */
	private static int sum(int n) {
		return n/100 + n/10%10 + n%10;
	}
	
	/*
	 * ��λ����λ֮��
	 */
	private static int mul(int n) {
		return (n/100) * (n/10%10) * (n%10);
	}

}
