// we will be using dynamic programming approach to solve this problem. Since there are only three colors we will be having three variables that wil be used to track the maximum value that can be gained by robbing each house the most maximum value can be returned.

// Time complexity: O(n) n--> number of houses

//Space Complexity: O(1)
public class PaintHouse{
    public static int HouseColoring(int[][] nums){
        //     int red = helper(nums, 0, 1, nums[0][0]);
        //     int blue = helper(nums, 1, 1, nums[0][1]);
        //     int green = helper(nums, 2, 1, nums[0][2]);
        //     return(Math.min(red, Math.min(blue,green)));
        // }
        // private static int helper(int[][] nums, int color, int index, int totalCost){
        //     // base cases
        //     if(index>=nums.length) return totalCost;
    
        //     //choices
        //     if(color == 0){
        //         return (Math.min(helper(nums, 1, index+1, totalCost+ nums[index][1]),helper(nums,2, index+1, totalCost+nums[index][2])));
        //     }
        //     else if(color == 1){
        //         return (Math.min(helper(nums, 0, index+1, totalCost+ nums[index][0]),helper(nums,2, index+1, totalCost+nums[index][2])));
        //     }
        //     else {
        //         return (Math.min(helper(nums, 1, index+1, totalCost+ nums[index][1]),helper(nums,0, index+1, totalCost+nums[index][0])));
        //     }
    
        int m = nums.length;
    
        // int[] tracker = new int[n];
        // for(int j =0; j<n;j++){
        //     tracker[j] = nums[0][j];
        // }
        int r = nums[0][0];
        int b = nums[0][1];
        int g = nums[0][2];
        for(int i=1;i<m;i++){
            int temp = r;
            r = nums[i][0] + Math.min(b,g);
            int temp2 = b;
            b = nums[i][1] + Math.min(temp,g);
            g = nums[i][2] + Math.min(temp,temp2);
    
        }
    
        return Math.min(r, Math.min(b,g));
        }
}