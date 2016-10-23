
public class TestDuJu {

	static int yazhu = 0;
	static int zongyazhu = 0;
	static int zhuangjia = 0;
	static int wanjia = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<500000; i++) {
			int a = (int)(Math.random()*6+1);
			int b1 = (int)(Math.random()*6+1);
			int b2 = (int)(Math.random()*6+1);
			int b3 = (int)(Math.random()*6+1);
			yazhu = 1;
			if((a==b1&a!=b2&a!=b3) || (a!=b1&a==b2&a!=b3) || (a!=b1&a!=b2&a==b3)) {
				yazhu = 0;
				wanjia = wanjia + 1;
			} else if((a==b1&a==b2&a!=b3) || (a==b1&a!=b2&a==b3) || (a!=b1&a==b2&a==b3)) {
				yazhu = 0;
				wanjia = wanjia + 2;
			} else if(a==b1&a==b2&a==b3) {
				yazhu = 0;
				wanjia = wanjia + 6;
			} else if((a*b1==b2*b3) || (a*b2==b1*b3) || (a*b3==b1*b2)) {
				yazhu = 0;
			} else {
				zongyazhu = zongyazhu + 1;
			}
		}
		System.out.println("押注总金额为：" + zongyazhu);
		System.out.println("玩家挣的钱：" + wanjia);
	}

}
