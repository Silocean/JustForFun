import java.util.ArrayList;
import java.util.List;

/**
����Ħ˹��ĳ�ű�̽�գ���������д��һ����ֵ���ʽ��
    ABCDE * ? = EDCBA
    ���Ի���˵����ABCDEӦ�ô���ͬ�����֣��ʺ�Ҳ����ĳ�����֣���
    ���������Ҳ�Ҳ�ǣ���
    ���ǣ����˳�Ĭ�˺þã�����û��������ʵĽ������
    �������ü���������ƣ��ҵ��ƽ�Ĵ𰸡�
    �� ABCDE �����������д������

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
			// ��֤������ֻ�����ͬ
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
