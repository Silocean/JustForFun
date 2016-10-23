
public class TestÖÜÆÚ´® {

	public static void main(String[] args) {
		String string = "abcabcabcabc";
		for(int i=1; i<string.length(); i++) {
			String str = string.substring(0, i);
			String tempStr = str;
			int temp = i;
			while(temp<string.length()) {
				tempStr += str;
				temp += i;
			}
			if(tempStr.equals(string)) {
				System.out.println(i);
				break;
			}
		}
	}

}
