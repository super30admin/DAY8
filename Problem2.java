public class Problem2 {
    //T.c - O(n);
    //S.c - O(1);
    // Any problem you faced while coding this : No
    //here we're going to bottom up approach starting from n-2 index and check the min between the next row.
    public static int paintHouse(int[][] nums){
        if(nums == null || nums.length ==0){
            return -1;
        }
        int n = nums.length;
        for(int i = n-2;i>=0;i--){
            //for 0 index, The cost till current house to paint will be min of next house 1, house 2.
            nums[i][0] = nums[i][0] + Math.min(nums[i+1][1],nums[i+1][2]);
            //for 1 index, The cost till current house to paint will be min of next house 0, house 2.
            nums[i][1] = nums[i][1] + Math.min(nums[i+1][0],nums[i+1][2]);
            //for 2 index, The cost till current house to paint will be min of next house 0, house 1.
            nums[i][2] = nums[i][2] + Math.min(nums[i+1][0],nums[i+1][1]);
        }
        return Math.min(nums[0][0],Math.min(nums[0][1],nums[0][2]));
    }
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("Cost to paintHouse : " + paintHouse(costs));
    }
}
