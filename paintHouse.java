    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/paint-house/
    Time Complexity for operators : o(m)
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Followed the choose and don't choose approach as suggested in image. And found the repatative sub problem.
        # Optimized approach: . 
                              
            # 1. Form the two-d matrix. first row values will be same as given in input.
              2. we will start with second row and first column, at first position with will get the minimum of 2nd and 3rd elemnt of previous row.
              3. At second position with will get the minimum of 1st and 3rd elemnt of previous row.
              4. At third position with will get the minimum of 1st and 2nd elemnt of previous row.
              5. At the end, we will return min of last all last row values
    */  

    public class paintHouse{
    public static void main(String args[]) {
                int costs[][]= new int[][] {{17, 2, 17},{16, 16, 5},{14, 3, 19}};
                System.out.println(minCost(costs));
            }
            
            
        public static int minCost(int costs[][]) {
                      
            if(costs.length==0)
                return 0;
        
        
            for(int i=1;i<costs.length;i++){
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);   
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);   
                costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);   
            }
        
            return Math.min(costs[costs.length - 1][2],Math.min(costs[costs.length - 1][0],costs[costs.length - 1][1]));
        }
}
