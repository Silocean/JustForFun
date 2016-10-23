package ¿∂«≈¡∑œ∞;

import java.util.Scanner;

public class Ω·µ„—°‘Ò {

	public static int M;

	public static int MAX = 100010;

	public static Edge edge[] = new Edge[MAX * 2];

	public static int head[] = new int[MAX];

	public static int dp[][] = new int[MAX][2];

	public static void main(String[] args) {
		int n;
		int s, t;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<head.length; i++) {
			head[i] = -1;
		}
		for (int i = 0; i < MAX * 2; i++) {
			edge[i] = new Edge();
		}
		for (int i = 1; i <= n; i++) {
			dp[i][1] = sc.nextInt();
		}
		for (int i = 1; i < n; i++) {
			s = sc.nextInt();
			t = sc.nextInt();
			add(s, t);
		}
		dfs(1, -1);
		int tmp = max(dp[1][0], dp[1][1]);
		System.out.println(tmp);
		sc.close();
	}

	private static void add(int from, int to) {
		edge[M].v = to;
		edge[M].next = head[from];
		head[from] = M++;
		edge[M].v = from;
		edge[M].next = head[to];
		head[to] = M++;
	}

	private static void dfs(int x, int pre) {
		for (int i = head[x]; i != -1; i = edge[i].next) {
			int v = edge[i].v;
			if (pre == v)
				continue;
			dfs(v, x);
			dp[x][1] += dp[v][0];
			dp[x][0] += max(dp[v][0], dp[v][1]);
		}
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}

class Edge {
	int v, next;
}