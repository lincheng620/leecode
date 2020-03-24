package first;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String string = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(string));
    }
    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j <= n;j++){
                if(allUnique(s,i,j)){
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for(int i = start;i < end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
                set.add(ch);
        }
        return true;
    }
}
