
public class TestCount3Quit {

	public static void main(String[] args) {
		boolean[] arr = new boolean[500];
		for(int i=0; i<arr.length; i++) {
			arr[i] = true;
		}
		int count = 0;
		int leftCount = 500;
		int index = 0;
		while(leftCount > 1) {
			if(arr[index] == true) {
				count ++;
				if(count == 3) {
					leftCount --;
					arr[index] = false;
					count = 0;
				}
			}
			index ++;
			if(index == 500) {
				index = 0;
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == true) {
				System.out.println(i);
			}
		}
	}

}
