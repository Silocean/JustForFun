
public class TestDeadLock implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDeadLock td1 = new TestDeadLock();
		TestDeadLock td2 = new TestDeadLock();
		td1.flag = 1;
		td2.flag = 0;
		new Thread(td1).start();
		new Thread(td2).start();
	}
	
	int flag = 1;
	
	static Object o1 = new Object();
	static Object o2 = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(flag);
		if(flag == 1) {
			synchronized(o1) {
				//System.out.println("oooooooo");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(o2) {
					System.out.println("=========");
				}
			}
		}
		
		if(flag == 0) {
			synchronized(o2) {
				//System.out.println("bbbbbbbbbb");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(o1) {
					System.out.println("+++++++++++++");
				}
			}
		}
	}
	

}
