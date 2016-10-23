
/**
A B C D中取5次，每个字母都可以重复取出，形成一个串。
现在要求，串中A出现的次数必须为偶数（0次也算偶数）。
求可以形成多少种可能的串。

 */
public class Test取字母组成串 {

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
