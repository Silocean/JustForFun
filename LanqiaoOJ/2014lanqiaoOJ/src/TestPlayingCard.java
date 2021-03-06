
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
小明刚上小学，学会了第一个扑克牌“魔术”，到处给人表演。魔术的内容是这样的：
他手里握着一叠扑克牌：A，2，....J，Q，K 一共13张。他先自己精心设计它们的顺序，然后正面朝下拿着，开始表演。
只见他先从最下面拿一张放到最上面，再从最下面拿一张翻开放桌子上，是A；然后再从最下面拿一张放到最上面，再从最下面拿一张翻开放桌子上，是2；......如此循环直到手中只有一张牌，翻开放桌子上，刚好是K。
这时，桌上牌的顺序是：A,2,3,4,5,6,7,8,9,10,J,Q,K
请你计算一下，小明最开始的时候手里牌的顺序是怎样的。
把结果写出来，逗号分割，小明“魔术”开始时，最下面的那张牌输出为第一个数据。
考场不提供扑克牌，你只能用计算机模拟了，撕碎草稿纸模拟扑克属于作弊行为！另外，你有没有把录像倒着放过？很有趣的！回去试试！

 */
public class TestPlayingCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		String[] arrStr = new String[]{"Q","J","10","9","8","7","6","5","4","3","2","A"};
		list.add("K");
		for(int i=0; i<arrStr.length; i++) {
			list.add(arrStr[i]);
			list.add(list.get(0));
			list.remove(0);
		}
		Iterator<String> it = ((LinkedList<String>) list).descendingIterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
