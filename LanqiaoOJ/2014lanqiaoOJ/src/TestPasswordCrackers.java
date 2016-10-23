import java.util.Scanner;


public class TestPasswordCrackers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = "";
		int count = 0;
		while(!(message=scan.nextLine()).equals("ENDOFINPUT")) {
			count ++;
			if(count==2) {
				// System.out.println(message);
				System.out.println(passwordCrack(message));
				count = -1;
			}
		}
	}

	private static StringBuffer passwordCrack(String message) {
		StringBuffer trueMessage = new StringBuffer();
		for(int i=0; i<message.length(); i++) {
			char c = message.charAt(i);
			if(c>='A'&&c<='Z'){
				int index = c - 5;;
				if(index<65) {
					index = 90-(5-(c-65))+1;
				}
				trueMessage.append((char)index);
			} else {
				trueMessage.append(c);
			}
		}
		return trueMessage;
	}

}
