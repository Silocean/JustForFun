
/**
������������������F��ʿ��
��ʿѯ����������ʱ������˵��������������С�Ĳ�����19�ꡣ����3�������ܺ�Ϊ70�ꡣ��������������ĳ˻������п�����������ġ�
�����F��ʿ�������ǵ����䣬��С�������У��ö��ŷֿ���

 */
public class Test�������� {

	public static void main(String[] args) {
		int max = 0;
		int x = 0, y = 0, z = 0;
		for(int a=0; a<=19; a++) {
			for(int b=19; b<=32; b++) {
				for(int c=19; c<=32; c++) {
					if(a+b+c == 70) {
						if(a*b*c>max) {
							max = a*b*c;
							x = a;
							y = b;
							z = c;
						}
					}
				}
			}
		}
		System.out.println(x + "," + y + "," + z);
	}

}
