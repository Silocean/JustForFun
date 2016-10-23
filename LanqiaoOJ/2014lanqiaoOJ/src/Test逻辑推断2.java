public class Test逻辑推断2 {

	/**
	 * @param args
	 */
	public int zhuanhua1(String s) {
		int a=0;
		a=Integer.parseInt(s, 2);
		
		return a;

	}
	public String zhuanhua2(int a) {
		String s="";
		
		for(;a!=0;a=a/2)
			s+=a%2;
		//System.out.println(s);

		char[] b=s.toCharArray();
		String s1="";
		char k;
		for(int i=s.length()-1;i>=0;i--){
			k=(char) (74-i);
			if(b[i]=='1')
				
				s1+=k+" ";
			
		}
		return s1;

	}
	public void count() {
		for(int count = 0;count<1024;count++){
			//1. 如果A参加，B也参加；
			boolean a1 = count/512%2==1?(count/256%2==1?true:false):true;
			//2. 如果C不参加，D也不参加；
			boolean a2= count/128%2==0?(count/64%4==0?true:false):true;
			//3. A和C中只能有一个人参加；
			boolean a3 = (count/512%2+count/128%2)<=1?true:false;
			//4. B和D中有且仅有一个人参加；
			boolean a4 = (count/256%2+count/64%2)<=1?true:false;
			//5. D、E、F、G、H 中至少有2人参加；
			boolean a5 = (count/4%2+count/8%2+count/16%2+count/32%2+count/64%2)>=2?true:false;
			//6. C和G或者都参加，或者都不参加；
			boolean a6 = count/128%2==1?(count/8%2==1?true:false):(count/8%2==0?true:false);
			//7. C、E、G、I中至多只能2人参加  
			boolean a7 = (count/2%2+count/8%2+count/32%2+count/128%2)<=2?true:false;
			//8. 如果E参加，那么F和G也都参加。
			boolean a8 = count/32%2==1?(count/8%4==3?true:false):true;
			//9. 如果F参加，G、H就不能参加
			boolean a9 = count/16%2==1?(count/4%4==0?true:false):true;      //a8和a9可以忽略
			//10. 如果I、J都不参加，H必须参加
			boolean a10 = count%4==0?(count/4%2==1?true:false):true;
			
			
			if(a1&&a2&&a3&&a4&&a5&&a6&&a7&&a8&&a9&&a10)
				{
				//System.out.println(count);
				System.out.println(new Test逻辑推断2().zhuanhua2(count));
				
				}
			
		}
	}
	public static void main(String[] args) {
		
		new Test逻辑推断2().count();

	}

}
