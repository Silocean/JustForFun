
/**
A、B、C、D、E、F、G、H、I、J 共10名学生有可能参加本次计算机竞赛，也可能不参加。因为某种原因，他们是否参赛受到下列条件的约束：

   1. 如果A参加，B也参加；
   2. 如果C不参加，D也不参加；
   3. A和C中只能有一个人参加；
   4. B和D中有且仅有一个人参加；
   5. D、E、F、G、H 中至少有2人参加；
   6. C和G或者都参加，或者都不参加；
   7. C、E、G、I中至多只能2人参加   
   8. 如果E参加，那么F和G也都参加。
   9. 如果F参加，G、H就不能参加
   10. 如果I、J都不参加，H必须参加

请编程根据这些条件判断这10名同学中参赛者名单。如果有多种可能，则输出所有的可能情况。每种情况占一行。参赛同学按字母升序排列，用空格分隔。

比如：
C D G J
就是一种可能的情况。

多种情况的前后顺序不重要
 */
public class Test逻辑推断 {

	
	public static int[] arr = {0,0,0,0,0,0,0,0,0,0};

	public static void main(String[] args) {
		print(0);
	}
	
	public static boolean check() {
		// 如果A参加，B也参加 (A->B <==> ~A或B)
		boolean condition1 = arr[0]==0 || arr[1]==1;
		// 如果C不参加，D也不参加
		boolean condition2 = arr[2]==1 || arr[3]==0;
		// A和C中只能有一个人参加
		boolean condition3 = arr[0] + arr[2] <=1;
		// B和D中有且仅有一个人参加
		boolean condition4 = arr[1] + arr[3] == 1;
		// D、E、F、G、H 中至少有2人参加
		boolean condition5 = arr[3] + arr[4] + arr[5] + arr[6] + arr[7]>= 2;
		// C和G或者都参加，或者都不参加
		boolean condition6 = arr[2]+arr[6]==2 || arr[2]+arr[6]==0;
		// C、E、G、I中至多只能2人参加
		boolean condition7 = arr[2] + arr[4] + arr[6] + arr[8] <=2;
		// 如果E参加，那么F和G也都参加
		boolean condition8 = arr[4]==0 || arr[5]+arr[6]==2;
		// 如果F参加，G、H就不能参加
		boolean condition9 = arr[5]==0 || arr[6]+arr[7]==0;
		// 如果I、J都不参加，H必须参加
		boolean condition10 = arr[8]+arr[9]>0 || arr[7]==1;
		
		return condition1&&condition2&&condition3&&condition4&&condition5&&condition6&&condition7&&condition8&&condition9;
		
	}
	
	/*public static void print() {
		for(int a = 0; a<2; a++) {
			for(int b=0; b<2; b++) {
				for(int c=0; c<2; c++) {
					for(int d=0; d<2; d++) {
						for(int e=0; e<2; e++) {
							for(int f=0; f<2; f++) {
								for(int g=0; g<2; g++) {
									for(int h=0; h<2; h++) {
										for(int i=0; i<2; i++) {
											for(int j=0; j<2; j++) {
												arr[0] = a;
												arr[1] = b;
												arr[2] = c;
												arr[3] = d;
												arr[4] = e;
												arr[5] = f;
												arr[6] = g;
												arr[7] = h;
												arr[8] = i;
												arr[9] = j;
												if(check()) {
													for(int n=0; n<arr.length; n++) {
														if(arr[n] == 1) {
															switch(n) {
															case 0: System.out.print("A ");
																break;
															case 1: System.out.print("B ");
																break;
															case 2: System.out.print("C ");
																break;
															case 3: System.out.print("D ");
																break;
															case 4: System.out.print("E ");
																break;
															case 5: System.out.print("F ");
																break;
															case 6: System.out.print("G ");
																break;
															case 7: System.out.print("H ");
																break;
															case 8: System.out.print("I ");
																break;
															case 9: System.out.print("J ");
																break;
															}
														}
														// System.out.print(arr[n] + " ");
													}
													System.out.println();
												}
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}*/
	
	public static void print(int index) {
		if(index == 10) {
			if(check()) {
				for(int n=0; n<arr.length; n++) {
					if(arr[n] == 1) {
						System.out.print((char)(n + 'A') + " ");
					}
					// System.out.print(arr[n] + " ");
				}
				System.out.println();
		}
		} else {
			arr[index] = 1;
			print(index + 1);
			arr[index] = 0;
			print(index + 1);
		}
	}

}
