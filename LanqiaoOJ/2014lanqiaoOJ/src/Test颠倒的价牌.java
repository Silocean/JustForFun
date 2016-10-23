
/**
    小李的店里专卖其它店中下架的样品电视机，可称为：样品电视专卖店。
    其标价都是4位数字（即千元不等）。
    小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了（参见p1.jpg）。
    这种价牌有个特点，对一些数字，倒过来看也是合理的数字。如：1 2 5 6 8 9 0 都可以。这样一来，如果牌子挂倒了，
    有可能完全变成了另一个价格，比如：1958 倒着挂就是：8561，差了几千元啊!!
    当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。
    有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!
    庆幸的是价格出入不大，其中一个价牌赔了2百多，另一个价牌却赚了8百多，综合起来，反而多赚了558元。
    请根据这些信息计算：赔钱的那个价牌正确的价格应该是多少？
 */
public class Test颠倒的价牌 {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,5,6,8,9,0},
				{1,2,5,9,8,6,0}};
		int[][] array1 = new int[2][100];
		int[][] array2 = new int[2][100];
		int count1 = 0;
		int count2 = 0;
		for(int a=0; a<arr[0].length-1; a++) {
			for(int b=0; b<arr[0].length; b++) {
				for(int c=0; c<arr[0].length; c++) {
					for(int d=0; d<arr[0].length-1; d++) {
						int price = arr[0][a]*1000+ arr[0][b]*100 + arr[0][c]*10 + arr[0][d];
						int _price = arr[1][d]*1000+ arr[1][c]*100 + arr[1][b]*10 + arr[1][a];
						if(_price-price>=-300 && _price-price<=-200) {
							array1[0][count1] = price;
							array1[1][count1] = _price;
							count1 ++;
						}
						if(_price-price>=800 && _price-price<=900) {
							array2[0][count2] = price;
							array2[1][count2] = _price;
							count2 ++;
						}
					}
				}
			}
		}
		for(int i=0; i<array1[0].length; i++) {
			for(int j=0; j<array2[0].length; j++) {
				if((array1[1][i]-array1[0][i]) + (array2[1][j]-array2[0][j]) == 558) {
					System.out.println(array1[0][i] + " " + array1[1][i] + "====" + array2[0][j] + " " + array2[1][j]);
				}
			}
		}
	}

}
