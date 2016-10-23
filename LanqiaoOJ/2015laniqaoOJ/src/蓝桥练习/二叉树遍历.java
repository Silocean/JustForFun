package 蓝桥练习;

/**
 * 遍历二叉树的四种方法
 * @author Silocean
 *
 */
public class 二叉树遍历 {

	public static int MAXSIZE = 100;

	public static Node queue[] = new Node[MAXSIZE];

	public static void main(String[] args) {
		Node h = new Node('H', null, null);
		Node i = new Node('I', null, null);
		Node f = new Node('F', h, i);
		Node g = new Node('G', null, null);
		Node d = new Node('D', null, null);
		Node e = new Node('E', null, null);
		Node b = new Node('B', d, e);
		Node c = new Node('C', f, g);
		Node a = new Node('A', b, c);
		System.out.print("preOrder:");
		preOrder(a);
		System.out.println();
		System.out.print("inOrder:");
		inOrder(a);
		System.out.println();
		System.out.print("postOrder:");
		postOrder(a);
		System.out.println();
		System.out.print("levelOrder:");
		levelOrder(a);
	}
	
	/**
	 * 先序遍历
	 * @param p
	 */
	private static void preOrder(Node p) {
		if(p!=null) {
			System.out.print(p.key + " ");
			preOrder(p.leftNode);
			preOrder(p.rightNode);
		}
	}
	
	/**
	 * 中序遍历
	 * @param p
	 */
	private static void inOrder(Node p) {
		if(p!=null) {
			inOrder(p.leftNode);
			System.out.print(p.key + " ");
			inOrder(p.rightNode);
		}
	}
	
	/**
	 * 后序遍历
	 * @param p
	 */
	private static void postOrder(Node p) {
		if(p!=null) {
			postOrder(p.leftNode);
			postOrder(p.rightNode);
			System.out.print(p.key + " ");
		}
	}

	/**
	 * 层次遍历
	 * @param p
	 */
	private static void levelOrder(Node p) {
		int front, rear;
		front = rear = 0;
		Node q;
		if (p != null) {
			rear = (rear + 1) % MAXSIZE;
			queue[rear] = p;
			while (front != rear) {
				front = (front + 1) % MAXSIZE;
				q = queue[front];
				System.out.print(q.key + " ");
				if (q.leftNode != null) {
					rear = (rear + 1) % MAXSIZE;
					queue[rear] = q.leftNode;
				}
				if (q.rightNode != null) {
					rear = (rear + 1) % MAXSIZE;
					queue[rear] = q.rightNode;
				}
			}
		}
	}

}

class Node {
	public char key;
	public Node leftNode;
	public Node rightNode;

	public Node(char key) {
		this(key, null, null);
	}

	public Node(char key, Node leftNode, Node rightNode) {
		this.key = key;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}
