public class TestThread1 {
	public static void main(String[] args) { // TODO Auto-generated method stub
		/*
		 * new Thread(new Left()).start(); new Thread(new Right()).start();
		 */
		new Left().start();
		new Right().start();
		for (int i = 0; i < 4; i++) {
			System.out.println("我是主线程--------");
			Thread.yield();
		}
	}
}

class Left extends Thread {
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("我是左手线程+++++++++");
			Thread.yield();
		}
	}
}

class Right extends Thread {
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("我是右手线程~~~~~~~~~");
			Thread.yield();
		}
	}
}