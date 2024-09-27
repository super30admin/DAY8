// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(3n) where n is the number of houses. This can be reduced to O(1) if we alter the 
// costs matrix in place.  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I ran another for loop from 0 to 2 inside the 1 to m loop 
// to fill the values and had to put many checks to compare the minimums for the correct indices.


// Your code here along with comments explaining your approach


class colorHouses {

    public static int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ans > dp[m-1][i]) 
                ans = dp[m-1][i];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
    }
}