package leetcode1;

public class Leetcode316 {
   public static int[] twoSum(int[] sums,int targets){
       int[] result = new int[2];
       for(int i = 0;i < sums.length;i++){
           for(int j = i + 1;j < sums.length;j++){
               if(targets == sums[i] + sums[j]){
                   result[0] = i;       //这里堵住了
                   result[1] = j;
                   break;
               }
           }
       }
       return result;//返回值不可以在循环里面，要跳出循环
   }
   public static void main(String[] args){
       int result[] = twoSum(new int[]{7, 9, 0, 6},6);//新的数组必须要new出来，不可以直接{7,9,0,6}
       //for(int i = 0;i < result.length;i++){}
       System.out.println("[" + result[0] + "," + result[1] + "]");//要输出[,要用双引号括起来
   }
}
