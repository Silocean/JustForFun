
public class ThreadComm {

	public static Thread ta = new Thread() {
		public void run() {
			while (true) {
				try {
					Thread.sleep(3600000);
				} catch (InterruptedException e) {
					System.out.println("Fuck you����Ҫ��");
				}
			}
		}
	};
	public static Thread tb = new Thread() {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					for (int i = 0; i < 3; i++)
						System.out.print("���𴲣�    ");
					System.out.print("\n");
					synchronized (ta) {
						ta.interrupt();
					}

				} catch (InterruptedException e) {
					// TODO Auto-generatedcatch block
					e.printStackTrace();
				}
			}
		}
	};

	public static void main(String[] args) {
		ta.start();
		tb.start();
	}
}