
public class TestChouJiang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] arr = new boolean[Integer.parseInt(args[0])];
		for(int i=0; i<arr.length; i++) {
			arr[i] = false;
		}
		int index = 1;
		int count = 0;
		while(arr[0] != true) {
			//arr[0] = true;
			count ++;
			if(count == Integer.parseInt(args[1])) {
				count = 0;
				arr[index] = true;
				if(index == 0) break;
			}
			index ++;
			if(index == arr.length) {
				index = 0;
			}
		}
		int countNum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == false) {
				//System.out.println(i);
				countNum ++;
			}
		}
		
		System.out.println("中奖的概率为" + (double)countNum/arr.length);
	}

}