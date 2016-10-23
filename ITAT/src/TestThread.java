public class TestThread {

	public static void main(String[] args) {
		Runner1 a = new Runner1();

		a.start();
	}

}

class Runner2 extends Thread {
	public void run() {
		try {
			Thread.sleep(60 * 60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return;
		}
	}
}

class Runner1 extends Thread {

	Runner2 b = new Runner2();

	public void run() {
		b.start();
		for (int i = 0; i < 3; i++) {
			System.out.println("Æð´²ÁË");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 2) {
				b.interrupt();
			}
		}
	}
}