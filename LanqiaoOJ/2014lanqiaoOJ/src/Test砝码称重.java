import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

5个砝码

用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。
如果只有5个砝码，重量分别是1，3，9，27，81。则它们可以组合称出1到121之间任意整数重量（砝码允许放在左右两个盘中）。
本题目要求编程实现：对用户给定的重量，给出砝码组合方案。
例如：
用户输入：
5
程序输出：
9-3-1
用户输入：
19
程序输出：
27-9+1

要求程序输出的组合总是大数在前小数在后。
可以假设用户的输入的数字符合范围1~121。

 */
public class Test砝码称重 {
	
	public static void main(String[] args) {
		int m = new Scanner(System.in).nextInt();
		for(int a=1; a>=-1; a--) {
			for(int b=1; b>=-1; b--) {
				for(int c=1; c>=-1; c--) {
					for(int d=1; d>=-1; d--) {
						for(int e=1; e>=-1; e--) {
							if(a*81+b*27+c*9+d*3+e*1 == m) {
								List<Integer> list = new ArrayList<Integer>();
								String str = "";
								if(a*81!=0) list.add(a*81);
								if(b*27!=0) list.add(b*27);
								if(c*9!=0) list.add(c*9);
								if(d*3!=0) list.add(d*3);
								if(e*1!=0) list.add(e*1);
								for(int i=0; i<list.size()-1; i++) {
									if(list.get(i+1)>0) {
										str += list.get(i)+"+";
									} else {
										str += list.get(i);
									}
								}
								str += list.get(list.size()-1);
								System.out.println(str);
							}
						}
					}
				}
			}
		}
	}

}
