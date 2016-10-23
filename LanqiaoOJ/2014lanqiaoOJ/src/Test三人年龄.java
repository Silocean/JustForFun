
/**
三个神秘蒙面人来访F博士。
博士询问他们年龄时，他们说：我们中年龄最小的不超过19岁。我们3人年龄总和为70岁。且我们三人年龄的乘积是所有可能情况中最大的。
请帮助F博士计算他们的年龄，从小到大排列，用逗号分开。

 */
public class Test三人年龄 {

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
