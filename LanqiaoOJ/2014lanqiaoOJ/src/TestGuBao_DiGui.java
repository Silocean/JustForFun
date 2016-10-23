import java.util.ArrayList;
import java.util.List;

/**
福尔摩斯到某古堡探险，看到门上写着一个奇怪的算式：
    ABCDE * ? = EDCBA
    他对华生说：“ABCDE应该代表不同的数字，问号也代表某个数字！”
    华生：“我猜也是！”
    于是，两人沉默了好久，还是没有算出合适的结果来。
    请你利用计算机的优势，找到破解的答案。
    把 ABCDE 所代表的数字写出来。

 */
public class TestGuBao_DiGui {
	
	public static int[] num = new int[5];

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			go(0, i);
		}
	}
	
	public static void go(int index, int m) {
		
		num[index] = m;
		
		if(index==4) {
			// 保证五个数字互不相同
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<num.length-1; i++) {
				list.add(num[i]);
				if(list.contains(num[i+1])) {
					return;
				}
			}
			
			int number = num[0]*10000 + num[1]*1000 + num[2]*100 + num[3]*10 + num[4];
			for(int i=0; i<10; i++) {
				if((number*i) == (num[4]*10000 + num[3]*1000 + num[2]*100 + num[1]*10 + num[0])) {
					for(int k=0; k<num.length; k++) {
						System.out.print(num[k]);
					}
					System.out.println(" " + i);
				}
			}
			return;
		} else {
			for(int i=0; i<10; i++) {
				go(index+1, i);
			}
		}
	}

}
