package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class hashTwoNumsSum1 {
    public static int[] twoNums(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int remain = target - nums[i];
            if(map.containsKey(remain)){
                return new int[]{i,map.get(remain)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no such two nums");
    }
    public static void main(String[] args){
        System.out.println("[" + twoNums(new int[]{23,1,89,43,8},9)[0] + "," +
                twoNums(new int[]{23,1,89,43,8},9)[1] + "]");
    }
}
