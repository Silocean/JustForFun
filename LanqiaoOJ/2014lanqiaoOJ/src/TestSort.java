
public class TestSort {

	public static void main(String[] args) {
		//selectionSort();
		bubbleSort();
	}

	private static void bubbleSort() {
		int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
		for(int i=0; i<arr.length; i++) {
			boolean flag = true; // ������������ȷ��ÿһ�α����Ƿ񶼽����˽���
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag) break;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void selectionSort() {
		int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
		for(int i=0; i<arr.length; i++) {
			int k = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[k]) {
					k = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
