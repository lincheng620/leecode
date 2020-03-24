package first;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String string = scanner.nextLine();
        System.out.println(lengthOfUniqueSubstring(string));
    }
    public static int lengthOfUniqueSubstring(String s){
        int[] hash = new int[500];
        int fast = 0;
        int slow = 0;
        int max = 0;
        while(fast < s.length() && slow < s.length()){
            if(hash[s.charAt(fast)] == 0){
                hash[s.charAt(fast)] = 1;
                fast++;
                max = Math.max(max,fast - slow);
            }else{
                hash[s.charAt(slow)] = 0;
                slow++;
            }
        }
        return max;
    }
}
