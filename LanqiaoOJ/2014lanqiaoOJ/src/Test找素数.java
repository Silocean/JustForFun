
public class TestÕÒËØÊı {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag;
		int count = 0;
		for(int i=1; i<=4000000; i++) {
			flag = true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j == 0) {
					flag = false;
				}
			}
			if(flag == false) continue;
			//System.out.println(i);
			count ++;
			if(count == 100002) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
