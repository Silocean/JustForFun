import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
����һ�����������ΪM �Ŀ�����N ��ʳƷ����ʳ�Σ����ǣ����׵ȡ���֪��i ��ʳƷ
�����ӵ��Wi�������Ʒ��ֵΪViԪ/������ȷ��һ��װ��������ʹ��װ�뿨���е�
������Ʒ�ܼ�ֵ���
 */
public class Test���ֱ������� {
	
	public static List<Food> list = new ArrayList<Food>();
	
	public static int m = 10;
	
	public static int maxValue = 0;

	public static void main(String[] args) {
		list.add(new Food(5, 2));
		list.add(new Food(4, 3));
		list.add(new Food(3, 4));
		Collections.sort(list);
		// System.out.println(list);
		getMaxValue(list);
		System.out.println(maxValue);
	}

	private static void getMaxValue(List<Food> list) {
		for(int i=list.size()-1; ; i--) {
			m -= list.get(i).weight;
			if(m>0) {
				maxValue += list.get(i).weight*list.get(i).price;
			} else {
				maxValue += m*list.get(i).price;
				break;
			}
		}
	}

}

class Food implements Comparable<Object> {
	
	int weight;
	int price;
	
	public Food(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int compareTo(Object o) {
		Food f = (Food)o;
		if(this.price < f.price) {
			return -1;
		} else if(this.price > f.price) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.price+"";
	}
	
}
