
public class Test�ݹ鷭�� {
	// ���������洢ÿ���ƣ�0��ʾ���泯�ϣ�1��ʾ���泯��
	public static int[] cards = new int[52];

	public static void main(String[] args) {
		fanPai(2);
		for(int i=0; i<cards.length; i++) {
			if(cards[i]==0) {
				System.out.print(i+" ");
			}
		}
	}
	
	private static void fanPai(int index) {
		if(index>52) {
			return;
		}
		for(int i=index; i<cards.length; i++) {
			if(i%index==0) {
				if(cards[i]==0) {
					cards[i] = 1;
				} else {
					cards[i] = 0;
				}
			}
		}
		fanPai(index+1);
	}

}
