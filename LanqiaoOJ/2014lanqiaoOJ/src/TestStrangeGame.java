
/**
ĳ����̨�ٰ��˵�̼�����������Ŀ�ļƷֹ����൱��֣�
ÿλѡ����Ҫ�ش�10�����⣨����Ϊ1��10����Խ����Խ���Ѷȡ���Եģ���ǰ�����������������۵��������ͬ�ķ�����ѡ�ֱ���ش����⣬���ش𰴴�������
ÿλѡ�ֶ���һ���𲽵ķ���Ϊ10�֡�
ĳ��ʤѡ�����յ÷ָպ���100�֣���������㿴�������̣������ƶϳ����������ĸ���Ŀ����ˣ��ĸ���Ŀ�������
����Ѵ�Եļ�Ϊ1�����ļ�Ϊ0����10����Ŀ�Ļش���������ý�����1��0�Ĵ�����ʾ�����磺0010110011 ���ǿ��ܵ������
���������������п��������ÿ����ռһ�С�
�����˳����Ҫ��

 */
public class TestStrangeGame {

	public static void main(String[] args) {
		f(0, 10);
	}

	static int[] arr = new int[10];

	public static void f(int time, int score) {
		if (time == 10) {
			if (score == 100) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}
		} else {
			arr[time] = 1;
			f(time + 1, score * 2);
			arr[time] = 0;
			f(time + 1, score - time - 1);
		}
	}

}
