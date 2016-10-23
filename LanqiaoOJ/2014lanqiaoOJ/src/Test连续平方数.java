
public class Test连续平方数 {

	public static void main(String[] args) {
		boolean flag = true;
		double sum = 0d;
		int index = 1;
		while(flag) {
			sum += Math.pow(index, 2);
			if(sum!=1 && Math.sqrt(sum)%1==0) {
				System.out.println(index);
				flag = false;
			}
			index ++;
		}
	}

}
