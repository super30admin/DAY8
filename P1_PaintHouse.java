// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;

        for(int i = n-2 ; i>=0 ; i--) {
            for(int j=0 ; j<m ; j++) {
                if(j==0) {
                    costs[i][j] = costs[i][j] + Math.min(costs[i+1][1], costs[i+1][2]);
                } else if(j==1) {
                    costs[i][j] = costs[i][j] + Math.min(costs[i+1][0], costs[i+1][2]);
                } else if(j==2) {
                    costs[i][j] = costs[i][j] + Math.min(costs[i+1][1], costs[i+1][0]);
                }
            }
        }
        int min = 999999;
        for(int j=0; j<m ;j++) {
            if(costs[0][j] < min) {
                min = costs[0][j];
            }
        }
        return min;
    }
}