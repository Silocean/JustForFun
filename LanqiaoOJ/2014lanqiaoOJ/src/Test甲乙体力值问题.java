/**
ĳ��Ϸ�����У�����˫��ÿ���غϵ�ս��������һ��ʤ����һ��ʧ�ܡ���Ϸ�涨��
ʧ�ܵ�һ��Ҫ���Լ�������ֵ��1/4�Ӹ�ʤ����һ�������磺���˫������ֵ��ǰ����4���򾭹�һ��ս����
˫��������ֵ���Ϊ��5��3��
������֪��˫����ʼʱ������ֵ�ף�1000���ң�2000��
����ս���У����һ�ʤ�ĸ��ʶ���50%
��⣺˫������4���غϵ�ս��������ֵ֮��С��1000�����۸��ʡ�
*/

public class Test��������ֵ���� {
	
	public static int count = 0;
	
	public static int pass = 0;
	
	public static void main(String[] args) {
		f(1000, 2000, 0);
		System.out.println("����Ϊ��" + ((double)pass/(double)count)*100 + "%");
		System.out.println(count);
	}
	
	public static void f(double a, double b, int index) {
		if(index == 4) {
			if(Math.abs(a-b)<1000) {
				pass ++;
			}
			count ++;
			return;
		} else {
			// �׷���ʤ
			a = a + b*1/4;
			b = b - b*1/4;
			f(a, b, index+1);
			
			// �ҷ���ʤ
			a = a - a*1/4;
			b = b + a*1/4;
			f(a, b, index+1);
		}
	}

}
