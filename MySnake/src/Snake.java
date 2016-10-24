import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Snake {
	Node head = null;
	Node tail = null;
	int size = 0;
	Node n = new Node(10, 15, Direction.L);
	private Yard y;

	public Snake(Yard y) {
		this.head = this.n;
		this.tail = this.n;
		this.size = 1;
		this.y = y;
	}

	public void draw(Graphics g) {
		if (size < 1)
			return;
		move();
		for (Node n = head; n != null; n = n.next) {
			n.draw(g);
		}
		if (isDead()) {
			y.stop();
		}
	}

	public void addToTail() {
		Node node = null;
		switch (tail.dir) {
		case L:
			node = new Node(tail.row, tail.col + 1, tail.dir);
			break;
		case U:
			node = new Node(tail.row + 1, tail.col, tail.dir);
			break;
		case R:
			node = new Node(tail.row, tail.col - 1, tail.dir);
			break;
		case D:
			node = new Node(tail.row - 1, tail.col, tail.dir);
			break;
		}
		tail.next = node;
		node.previous = tail;
		tail = node;
		size++;
	}

	public void addToHead() {
		Node node = null;
		switch (head.dir) {
		case L:
			node = new Node(head.row, head.col - 1, head.dir);
			break;
		case U:
			node = new Node(head.row - 1, head.col, head.dir);
			break;
		case R:
			node = new Node(head.row, head.col + 1, head.dir);
			break;
		case D:
			node = new Node(head.row + 1, head.col, head.dir);
			break;
		}
		node.next = head;
		head.previous = node;
		head = node;
		size++;
	}

	public void move() {
		addToHead();
		deleteFromTail();
	}

	private void deleteFromTail() {
		if (size < 1)
			return;
		tail = tail.previous;
		tail.next = null;
	}

	public void eat(Egg e) {
		if (this.getRect().intersects(e.getRect())) {
			e.reAppear();
			addToTail();
			MainFrame.score += 10;
		}
	}

	public boolean isDead() {
		if (head.col < 0 || head.row < 0 || head.col > Yard.COLS
				|| head.row > Yard.ROWS) {
			return true;
		} else if (isCollidedWithItself()) {
			return true;
		}
		return false;
	}

	private boolean isCollidedWithItself() {

		for (Node n = head.next; n != null; n = n.next) {
			if (head.col == n.col && head.row == n.row) {
				return true;
			}

		}
		return false;
	}

	public Rectangle getRect() {
		return new Rectangle(head.col * Yard.BLOCK_SIZE, head.row
				* Yard.BLOCK_SIZE, head.w, head.h);
	}

	private class Node {
		int row, col;
		int w = Yard.BLOCK_SIZE, h = Yard.BLOCK_SIZE;
		Direction dir;
		Node next = null;
		Node previous = null;

		public Node(int row, int col, Direction dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

		public void draw(Graphics g) {
			Color c = g.getColor();
			g.fill3DRect(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, w, h,
					true);
			g.setColor(c);
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_A:
			if (head.dir != Direction.R)
				head.dir = Direction.L;
			System.out.println("L");
			break;
		case KeyEvent.VK_W:
			if (head.dir != Direction.D)
				head.dir = Direction.U;
			System.out.println("U");
			break;
		case KeyEvent.VK_D:
			if (head.dir != Direction.L)
				head.dir = Direction.R;
			System.out.println("R");
			break;
		case KeyEvent.VK_S:
			if (head.dir != Direction.U)
				head.dir = Direction.D;
			System.out.println("D");
			break;
		}
	}

}
