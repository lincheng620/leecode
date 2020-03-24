package leetcode1;
/*
1.判断z升是否小于x和y的总和
2.若x和y都是偶数，Z为奇数，则输出flase
3.   3，8，4--[3,8,1,2,4,7,6,5,9,10,11]

     2,6--[2,6,4,8]
*/
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        int p,i,q = 0;
        if(x > y){
            p = x;
            x = y;
            y = p;
        }
        if(x + y < z){
            return false;
        }else if(x + y == z || x == z || y == z){
            return true;
        }else if(x%2 == 0 && y%2 == 0 && z%2 !=0){
            return false;
        }else{
            while(q >= y){

            }
        }
        return false;
    }

}
