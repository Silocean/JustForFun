
/**
����ƹ����ӽ��б������������ˡ��׶�Ϊa,b,c���ˣ��Ҷ�Ϊx,y,z���ˡ��ѳ�ǩ��������������
�������Ա����������������a˵������x�ȣ�c˵������x,z�ȣ��������ҳ��������ֵ�������
 */
public class Testƹ������� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(char a='x'; a<='z'; a++) {
			for(char b='x'; b<='z'; b++) {
				for(char c='x'; c<='z'; c++) {
					if(a!='x'&&c!='x'&&c!='z'&&a!=b&&a!=c&&b!=c) {
						System.out.println("a-" + a);
						System.out.println("b-" + b);
						System.out.println("c-" + c);
					}
				}
			}
		}
	}

}
