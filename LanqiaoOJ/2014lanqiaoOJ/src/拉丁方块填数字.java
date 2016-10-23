/*	方块填数
 “数独”是当下炙手可热的智力游戏。一般认为它的起源是“拉丁方块”，是大数学家欧拉于1783年发明的。
如图[1.jpg]所示：6x6的小格被分为6个部分（图中用不同的颜色区分）,每个部分含有6个小格（以下也称为分组）。
    开始的时候，某些小格中已经填写了字母（ABCDEF之一）。需要在所有剩下的小格中补填字母。
    全部填好后，必须满足如下约束：
    1. 所填字母只允许是A,B,C,D,E,F 中的某一个。
    2. 每行的6个小格中，所填写的字母不能重复。
    3. 每列的6个小格中，所填写的字母不能重复。
    4. 每个分组（参见图中不同颜色表示）包含的6个小格中，所填写的字母不能重复。
    为了表示上的方便，我们用下面的6阶方阵来表示图[1.jpg]对应的分组情况（组号为0~5）：
000011
022013
221113
243333
244455
445555
    用下面的数据表示其已有字母的填写情况：
02C
03B
05A
20D
35E
53F
    很明显，第一列表示行号，第二列表示列号，第三列表示填写的字母。行号、列号都从0开始计算。
    一种可行的填写方案（此题刚好答案唯一）为：
E F C B D A
A C E D F B
D A B E C F
F B D C A E
B D F A E C
C E A F B D
    你的任务是：编写程序，对一般的拉丁方块问题求解，如果多解，要求找到所有解。
【输入、输出格式要求】
    用户首先输入6行数据，表示拉丁方块的分组情况。
    接着用户输入一个整数n (n<36), 表示接下来的数据行数
    接着输入n行数据，每行表示一个预先填写的字母。
    程序则输出所有可能的解（各个解间的顺序不重要）。
    每个解占用7行。

    即，先输出一个整数，表示该解的序号（从1开始），接着输出一个6x6的字母方阵，表示该解。
    解的字母之间用空格分开。
    如果找不到任何满足条件的解，则输出“无解”
    例如：用户输入：
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

    则程序输出：
1
E F C B D A
A C E D F B
D A B E C F
F B D C A E
B D F A E C
C E A F B D

   再如，用户输入：
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
    则程序输出：
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

public class 拉丁方块填数字 {
	static int count = 0;
	// 显示矩阵
	public static void show(char[][] m){
		System.out.println(++count);
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	// 输入数据初始化操作
	public static void init(char[][] m, char[][] gArr,
			List<List<Point>> gLis) {
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<gArr.length;i++){	// 输入分组
			gArr[i] = scan.nextLine().toCharArray();
		}
		for(int i=0;i<gArr.length;i++){	// 初始gLis的长度为6个空list
			gLis.add(new ArrayList<Point>());
		}
		for(int i=0;i<gArr.length;i++){	// 用  gArr 为  gLis 赋值(记录每个分组的坐标)
			for(int j=0;j<gArr[i].length;j++){
				gLis.get(gArr[i][j]-'0').add(new Point(i,j));
				m[i][j] = '0';	// 顺便为矩阵赋初始值为全'0'
			}
		}
		int n = scan.nextInt();	// 初始填写字母个数
		scan.nextLine();
		for(int i=0;i<n;i++){	// 输入初始填写的字母
			char[] c = scan.nextLine().toCharArray();
			m[c[0]-'0'][c[1]-'0'] = c[2];
		}
	}
	// 分组检测(分组里是否存在 c)
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
	// 行列(RC)检测 (是否存在 c)
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
	// 检测 c是否可行
	public static boolean check(char[][] m, List<List<Point>> gLis, int row,
			int col, int gI,int x) {
		return !checkG(m,gI,gLis,(char)('A'+x))&&	// 分组里 没有c
				!checkRC(m,(char)('A'+x),row,col);	// 行列检测 没有c
	}
	// 递归探测
	public static void f(char[][] m,char[][] gArr,
			List<List<Point>> gLis,int row,int col){
		if(row==6){		// 最后一行都执行完了
			show(m);	// 输出
			return ;	// 结束并返回
		}
		if(m[row][col]!='0'){	// 不为0,说明有字母,进行下个位置探测
			if(col+1==6){	// 如果列读到了最后,行加1,列=0再进行探测
				f(m,gArr,gLis,row+1,0);	
			}else{	// 列+1,再进行探测
				f(m,gArr,gLis,row,col+1);
			}
		}else{
			for(int i=0;i<6;i++){
				if(check(m,gLis,row,col,gArr[row][col]-'0',i)){
					char temp = m[row][col];	// 暂存要替换矩阵原来的元素
					m[row][col] = (char)('A'+i);
					if(col+1==6){	// 如果列读到了最后,行加1,列=0再进行探测
						f(m,gArr,gLis,row+1,0);	
					}else{	// 列+1,再进行探测
						f(m,gArr,gLis,row,col+1);
					}
					m[row][col] = temp;
				}
			}
		}
	}
	// 主函数
	public static void main(String[] args) {
		char[][] m = new char[6][6];	// 矩阵
		char[][] gArr = new char[6][];		// 分组
		List<List<Point>> gLis;	// 记录分组的每个元素的坐标
		gLis = new ArrayList<List<Point>>();
		init(m, gArr,gLis);		// 输入数据初始化操作
		f(m,gArr,gLis,0,0);	// 递归探测
	}
}