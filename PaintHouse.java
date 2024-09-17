// Time Complexity : O(n) n=rows=houses. 
// Space Complexity : O(m) m=colors=costs[0].length;
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//Runtime: 0 ms, faster than 100.00% of Java online submissions for Paint House.
//Memory Usage: 39.3 MB, less than 94.12% of Java online submissions for Paint House.

    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0)
            return 0;
        int dp[]= new int[costs[0].length];
        for (int i=0;i<costs[0].length;i++){
            dp[i]=costs[0][i];
        }
        for (int i=1;i<costs.length;i++){
            int prevDP0=dp[0];
            int prevDP1=dp[1];
            dp[0]=costs[i][0]+Math.min(prevDP1,dp[2]);
            dp[1]=costs[i][1]+Math.min(prevDP0,dp[2]);
            dp[2]=costs[i][2]+Math.min(prevDP0,prevDP1);
        }
        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }