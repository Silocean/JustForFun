
/**
黄金分割数0.618与美学有重要的关系。舞台上报幕员所站的位置大约就是舞台宽度的0.618处，墙上的画像一般也挂在房间高度的0.618处，甚至股票的波动据说也能找到0.618的影子....
黄金分割数是个无理数，也就是无法表示为两个整数的比值。0.618只是它的近似值，其真值可以通过对5开方减去1再除以2来获得，我们取它的一个较精确的近似值：0.618034
有趣的是，一些简单的数列中也会包含这个无理数，这很令数学家震惊！
1 3 4 7 11 18 29 47 .... 称为“鲁卡斯队列”。它后面的每一个项都是前边两项的和。
如果观察前后两项的比值，即：1/3,3/4,4/7,7/11,11/18 ... 会发现它越来越接近于黄金分割数！
你的任务就是计算出从哪一项开始，这个比值四舍五入后已经达到了与0.618034一致的精度。
请写出该比值。格式是：分子/分母。比如：29/47

 */
public class Test黄金队列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=3; i<20; i++) {
			double num = f(i-1)/f(i);
			if(num<0.6180344&&num>0.6180335) {
				System.out.println(num + " " + i);
			}
		}
	}
	
	/*public static double f(int index) {
		double d1 = 1.0;
		double d2 = 3.0;
		double d = 0;
		for(int i=0; i<=index-2; i++) {
			d = d1 + d2;
			d1 = d2;
			d2 = d;
		}
		return d1/d;
	}*/
	
	public static double f(int index) {
		if(index == 1) return 1;
		if(index == 2) return 3;
		return f(index-1) + f(index-2);
	}

}
