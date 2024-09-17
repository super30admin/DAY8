/**
 * Time Complexity - O(n)  n= number of rows
 * Space Complexity - O(1) - Inplace
 * This code ran on Leetcode
 */

class Solution {
    public int minCost(int[][] costs) {
        int houses = costs.length;
        if( costs==null || costs.length==0){
            return 0;
        }


        for(int i=1; i<houses ; i++){
            //R
            costs[i][0]+= Math.min(costs[i-1][1], costs[i-1][2]);

            //Y
            costs[i][1]+= Math.min(costs[i-1][0], costs[i-1][2]);

            // B
            costs[i][2]+= Math.min(costs[i-1][0], costs[i-1][1]);


        }

        return Math.min(costs[houses-1][0], Math.min(costs[houses-1][1], costs[houses-1][2]));

    }
}