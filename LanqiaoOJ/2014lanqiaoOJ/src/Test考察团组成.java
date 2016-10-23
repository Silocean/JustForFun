
/**
3.	考察团组成
某饭店招待国外考察团。按照标准，对领导是400元/人，随团职员200元/人，对司机50元/人。
考察团共36人，招待费结算为3600元，请问领导、职员、司机各几人。
答案是三个整数，用逗号分隔。

 */
public class Test考察团组成 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a=1; a<=36; a++) {
			for(int b=1; b<=36; b++) {
				for(int c=1; c<=36; c++) {
					if(a*400+b*200+c*50==3600 && a+b+c==36) {
						System.out.println(a+","+b+","+c);
					}
				}
			}
		}
	}

}
