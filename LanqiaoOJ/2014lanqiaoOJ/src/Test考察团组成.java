
/**
3.	���������
ĳ�����д����⿼���š����ձ�׼�����쵼��400Ԫ/�ˣ�����ְԱ200Ԫ/�ˣ���˾��50Ԫ/�ˡ�
�����Ź�36�ˣ��д��ѽ���Ϊ3600Ԫ�������쵼��ְԱ��˾�������ˡ�
���������������ö��ŷָ���

 */
public class Test��������� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a=1; a<=36; a++) {
			for(int b=1; b<=36; b++) {
				for(int c=1; c<=36; c++) {
					if(a*400+b*200+c*50==3600 && a+b+c==36) {
						System.out.println(a+","+b+","+c);
					}
				}
			}
		}
	}

}
