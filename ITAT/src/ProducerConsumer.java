
public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumer pc = new ProducerConsumer();
		Container c = new Container();
		new Thread(new Producer(c)).start();
		new Thread(new Consumer(c)).start();
	}

}

class Container {
	Bullet[] bullet = new Bullet[12];
	int index = 0;
	
	public synchronized void push(Bullet b) {
		while(index == bullet.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		bullet[index] = b;
		index ++;
	}
	
	public synchronized Bullet pop() {
		while(index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		index --;
		return bullet[index];
	}
	
}

class Bullet {
	int id;
	public Bullet(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "bullet:" + id;
	}
}

class Producer implements Runnable{
	Container c;
	public Producer(Container c) {
		this.c = c;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			Bullet b = new Bullet(i);
			c.push(b);
			System.out.println("生产了：" + b);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable{
	Container c;
	public Consumer(Container c) {
		this.c = c;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			Bullet b = c.pop();
			System.out.println("消费了：" + b);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}