
/**
A B C D��ȡ5�Σ�ÿ����ĸ�������ظ�ȡ�����γ�һ������
����Ҫ�󣬴���A���ֵĴ�������Ϊż����0��Ҳ��ż������
������γɶ����ֿ��ܵĴ���

 */
public class Testȡ��ĸ��ɴ� {

	public static void main(String[] args) {
		String str = "";
		int num = 0;
		for(char a='A'; a<='D'; a++) {
			for(char b='A'; b<='D'; b++) {
				for(char c='A'; c<='D'; c++) {
					for(char d='A'; d<='D'; d++) {
						for(char e='A'; e<='D'; e++) {
							str = a+""+b+""+c+""+d+""+e;
							int count = 0;
							for(int i=0; i<str.length(); i++) {
								if(str.charAt(i)=='A') {
									count ++;
								}
							}
							if(count%2!=0) {
								continue;
							}
							num ++;
						}
					}
				}
			}
		}
		System.out.println(num);
	}

}
