package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class hashTwoNumsSum {
    public static int[] twoNums(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i < nums.length;i++){
            int remain = target - nums[i];
            if(map.containsKey(remain) && map.get(remain) != i){
                return new int[]{i,map.get(remain)};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
    public static void main(String[] args){
        //为什么一定要有static才能运行main():没有static只能实例化对象中调用main()才能运行
        System.out.println("[" + twoNums(new int[]{23,1,89,43,8},9)[0] + "," +
                twoNums(new int[]{23,1,89,43,8},9)[1] + "]");
    }
}
