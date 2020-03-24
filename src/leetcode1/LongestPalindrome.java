package leetcode1;

public class LongestPalindrome {
    public static int longestPalindrome1(String s) {
        char[] strArr = s.toCharArray();
        int[] count = new int[200];
        int sum = 0;
        int carr = 0;
        for(int i = 0;i < strArr.length;i++){
            count[(int)strArr[i]] = count[(int)strArr[i]] + 1;//可以直接count(s.charAt(i))不需要字符串转字符
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] % 2 == 0){
                sum = sum + count[i];
            }else {
                sum = sum + count[i] - 1;
                carr = 1;//这里改为：if(strArr.length > sum){ sum += 1;}
            }
        }
        return sum + carr;
    }
    public static void main(String[] args){
        int sum = longestPalindrome1("abccccdd");
        System.out.println(sum);
    }
}
