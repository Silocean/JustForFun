
public class Test�ҹھ� {

	public static void main(String[] args) {
		for(int a=0; a<2; a++) {
			for(int b=0; b<2; b++) {
				for(int c=0; c<2; c++) {
					for(int d=0; d<2; d++) {
						if((a==0&&d==0) || (a==0&&d==1) || (a==1&&d==0) || (a==1&&c==1) || (b==1&&c==0) || (b==1&&d==1)) {
							continue;
						}
						// System.out.println(a + " " + b + " " + c + "  " + d);
						if(a==0) System.out.println("�һ�Ǧ��ھ�");
						if(a==1) System.out.println("�������߹ھ�");
						if(b==0) System.out.println("�׻���׹ھ�");
						if(b==1) System.out.println("�����Զ�ھ�");
						if(c==0) System.out.println("������Զ�ھ�");
						if(c==1) System.out.println("��������׹ھ�");
						if(d==0) System.out.println("�һ����߹ھ�");
						if(d==1) System.out.println("���Ǧ��ھ�");
						
					}
				}
			}
		}
	}

}
