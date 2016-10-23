import java.util.Scanner;


public class Test制作表格 {
	
	public static String[][] table; 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		table = new String[2*m+1][2*n+1];
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++) {
				table[i][j] = " ";
			}
		}
		drawTable();
		printTable();
	}

	private static void printTable() {
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

	private static void drawTable() {
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++) {
				if(i==0 && j==0) {
					table[i][j] = "┌";
				} else if(i==0 && j==table[i].length-1) {
					table[i][j] = "┐";
				} else if(i==table.length-1 && j==0) {
					table[i][j] = "└";
				} else if(i==table.length-1 && j==table[i].length-1) {
					table[i][j] = "┘";
				} else if(i==0 && j%2==0) {
					table[i][j] = "┬";
				} else if(i%2==0 && j==0) {
					table[i][j] = "├";
				} else if(i%2==0 && j==table[i].length-1) {
					table[i][j] = "┤";
				} else if(i==table.length-1 && j%2==0) {
					table[i][j] = "┴";
				} else if(i%2==0 && j%2==1) {
					table[i][j] = "─";
				} else if(i%2==1 && j%2==0) {
					table[i][j] = "|";
				} else if(i%2==0 && j%2==0) {
					table[i][j] = "┼";
				}
			}
		}
	}

}
