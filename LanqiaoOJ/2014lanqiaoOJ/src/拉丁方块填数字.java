/*	��������
 ���������ǵ������ֿ��ȵ�������Ϸ��һ����Ϊ������Դ�ǡ��������顱���Ǵ���ѧ��ŷ����1783�귢���ġ�
��ͼ[1.jpg]��ʾ��6x6��С�񱻷�Ϊ6�����֣�ͼ���ò�ͬ����ɫ���֣�,ÿ�����ֺ���6��С������Ҳ��Ϊ���飩��
    ��ʼ��ʱ��ĳЩС�����Ѿ���д����ĸ��ABCDEF֮һ������Ҫ������ʣ�µ�С���в�����ĸ��
    ȫ����ú󣬱�����������Լ����
    1. ������ĸֻ������A,B,C,D,E,F �е�ĳһ����
    2. ÿ�е�6��С���У�����д����ĸ�����ظ���
    3. ÿ�е�6��С���У�����д����ĸ�����ظ���
    4. ÿ�����飨�μ�ͼ�в�ͬ��ɫ��ʾ��������6��С���У�����д����ĸ�����ظ���
    Ϊ�˱�ʾ�ϵķ��㣬�����������6�׷�������ʾͼ[1.jpg]��Ӧ�ķ�����������Ϊ0~5����
000011
022013
221113
243333
244455
445555
    ����������ݱ�ʾ��������ĸ����д�����
02C
03B
05A
20D
35E
53F
    �����ԣ���һ�б�ʾ�кţ��ڶ��б�ʾ�кţ������б�ʾ��д����ĸ���кš��кŶ���0��ʼ���㡣
    һ�ֿ��е���д����������պô�Ψһ��Ϊ��
E F C B D A
A C E D F B
D A B E C F
F B D C A E
B D F A E C
C E A F B D
    ��������ǣ���д���򣬶�һ�����������������⣬�����⣬Ҫ���ҵ����н⡣
�����롢�����ʽҪ��
    �û���������6�����ݣ���ʾ��������ķ��������
    �����û�����һ������n (n<36), ��ʾ����������������
    ��������n�����ݣ�ÿ�б�ʾһ��Ԥ����д����ĸ��
    ������������п��ܵĽ⣨��������˳����Ҫ����
    ÿ����ռ��7�С�

    ���������һ����������ʾ�ý����ţ���1��ʼ�����������һ��6x6����ĸ���󣬱�ʾ�ý⡣
    �����ĸ֮���ÿո�ֿ���
    ����Ҳ����κ����������Ľ⣬��������޽⡱
    ���磺�û����룺
000011
022013
221113
243333
244455
445555
6
02C
03B
05A
20D
35E
53F

    ����������
1
E F C B D A
A C E D F B
D A B E C F
F B D C A E
B D F A E C
C E A F B D

   ���磬�û����룺
001111
002113
022243
022443
544433
555553
7
04B
05A
13D
14C
24E
50C
51A
    ����������
1
D C E F B A
E F A D C B
A B F C E D
B E D A F C
F D C B A E
C A B E D F
2
D C E F B A
E F A D C B
A D F B E C
B E C A F D
F B D C A E
C A B E D F
3
D C F E B A
A E B D C F
F D A C E B
B F E A D C
E B C F A D
C A D B F E
4
D C F E B A
B E A D C F
A D C F E B
F B E A D C
E F B C A D
C A D B F E
5
D C F E B A
E F A D C B
A B C F E D
B E D A F C
F D B C A E
C A E B D F
6
D C F E B A
E F A D C B
A B D F E C
B E C A F D
F D B C A E
C A E B D F
7
D C F E B A
E F A D C B
A D B F E C
B E C A F D
F B D C A E
C A E B D F
8
D C F E B A
F E A D C B
A D B C E F
B F E A D C
E B C F A D
C A D B F E
9
D C F E B A
F E A D C B
A F C B E D
B D E A F C
E B D C A F
C A B F D E
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

public class �������������� {
	static int count = 0;
	// ��ʾ����
	public static void show(char[][] m){
		System.out.println(++count);
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	// �������ݳ�ʼ������
	public static void init(char[][] m, char[][] gArr,
			List<List<Point>> gLis) {
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<gArr.length;i++){	// �������
			gArr[i] = scan.nextLine().toCharArray();
		}
		for(int i=0;i<gArr.length;i++){	// ��ʼgLis�ĳ���Ϊ6����list
			gLis.add(new ArrayList<Point>());
		}
		for(int i=0;i<gArr.length;i++){	// ��  gArr Ϊ  gLis ��ֵ(��¼ÿ�����������)
			for(int j=0;j<gArr[i].length;j++){
				gLis.get(gArr[i][j]-'0').add(new Point(i,j));
				m[i][j] = '0';	// ˳��Ϊ���󸳳�ʼֵΪȫ'0'
			}
		}
		int n = scan.nextInt();	// ��ʼ��д��ĸ����
		scan.nextLine();
		for(int i=0;i<n;i++){	// �����ʼ��д����ĸ
			char[] c = scan.nextLine().toCharArray();
			m[c[0]-'0'][c[1]-'0'] = c[2];
		}
	}
	// ������(�������Ƿ���� c)
	public static boolean checkG(char[][] m,int gI,
			List<List<Point>> gLis,char c){
		for(int i=0;i<gLis.get(0).size();i++){
			int x = gLis.get(gI).get(i).x;
			int y = gLis.get(gI).get(i).y;
			if(c==m[x][y]){
				return true;
			}
		}
		return false;
	}
	// ����(RC)��� (�Ƿ���� c)
	public static boolean checkRC(char[][] m,char c,int row,int col){
		for(int i=0;i<m.length;i++){
			if(m[i][col]==c){
				return true;
			}
			if(m[row][i]==c){
				return true;
			}
		}
		return false;
	}
	// ��� c�Ƿ����
	public static boolean check(char[][] m, List<List<Point>> gLis, int row,
			int col, int gI,int x) {
		return !checkG(m,gI,gLis,(char)('A'+x))&&	// ������ û��c
				!checkRC(m,(char)('A'+x),row,col);	// ���м�� û��c
	}
	// �ݹ�̽��
	public static void f(char[][] m,char[][] gArr,
			List<List<Point>> gLis,int row,int col){
		if(row==6){		// ���һ�ж�ִ������
			show(m);	// ���
			return ;	// ����������
		}
		if(m[row][col]!='0'){	// ��Ϊ0,˵������ĸ,�����¸�λ��̽��
			if(col+1==6){	// ����ж��������,�м�1,��=0�ٽ���̽��
				f(m,gArr,gLis,row+1,0);	
			}else{	// ��+1,�ٽ���̽��
				f(m,gArr,gLis,row,col+1);
			}
		}else{
			for(int i=0;i<6;i++){
				if(check(m,gLis,row,col,gArr[row][col]-'0',i)){
					char temp = m[row][col];	// �ݴ�Ҫ�滻����ԭ����Ԫ��
					m[row][col] = (char)('A'+i);
					if(col+1==6){	// ����ж��������,�м�1,��=0�ٽ���̽��
						f(m,gArr,gLis,row+1,0);	
					}else{	// ��+1,�ٽ���̽��
						f(m,gArr,gLis,row,col+1);
					}
					m[row][col] = temp;
				}
			}
		}
	}
	// ������
	public static void main(String[] args) {
		char[][] m = new char[6][6];	// ����
		char[][] gArr = new char[6][];		// ����
		List<List<Point>> gLis;	// ��¼�����ÿ��Ԫ�ص�����
		gLis = new ArrayList<List<Point>>();
		init(m, gArr,gLis);		// �������ݳ�ʼ������
		f(m,gArr,gLis,0,0);	// �ݹ�̽��
	}
}