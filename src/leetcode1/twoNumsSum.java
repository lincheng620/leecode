package leetcode1;

class twoNumsSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(target == nums[i] + nums[j]){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;

    }
    public static void main(String[] args){
        //Solution solution = new Solution();
        int[] result = twoSum(new int[]{2,89,5,7},9);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
