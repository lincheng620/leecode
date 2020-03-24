package leetcode1;

public class Rectan {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2){
        int[] r1 = rec1;
        int[] r2 = rec2;
        if(r1[2] <= r2[0] || r1[1] >= r2[3] || r1[0] >= r2[2] || r1[3] <= r2[1]){
            return false;//不重叠
        }else {
            return true;//重叠
        }
    }

    public static void main(String[] args){
        boolean result = isRectangleOverlap(new int[]{-6,-10,9,2},new int[]{0,5,4,8});
        System.out.println(result);
    }
}
