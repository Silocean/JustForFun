 
public class CountChar {
 
   public static void main(String[] args) {
      int[] ori={1,3,4,7,2,1,1,5,2};
      int ori_len=ori.length;
      int[] count=new int[ori_len];
      int[] most=new int[ori_len];
      int count_max=count[0];
      int most_max=most[0];
     
      for(int i=0;i<ori_len;i++)
          for(int j=0;j<ori_len;j++)
             if(ori[i]==ori[j])
                count[i]++;
     
      //查看各个数字出现的次数
      for(int i=0;i<count.length;i++)
            System.out.print(count[i]);
     
      System.out.print("\n");
     
        //求得count数组的最大值
      for(int i=1;i<count.length;i++)
         if(count_max<count[i])
            count_max=count[i];
     
      //求得count最大值count[i]对应的m[i]（m[i]可能有多个）
      for(int i=0,j=0;i<count.length;i++)
         if(count[i]==count_max)
            most[j++]=ori[i];//将出现次数最多的ori[i]赋给most数组（ori[i]可能有多个）
     
      //得到most数组的最大值，
      for(int i=1;i<most.length;i++)
         if(most_max<most[i])
            most_max=most[i];
     
      System.out.print(most_max);
   }
 
}