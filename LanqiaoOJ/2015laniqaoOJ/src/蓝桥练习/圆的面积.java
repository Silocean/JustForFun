package ������ϰ;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Բ����� {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		double r = new Scanner(System.in).nextDouble();
		double square = Math.PI * r * r;
		DecimalFormat df = new DecimalFormat("#.0000000");
		System.out.println(df.format(square));
	}

}
