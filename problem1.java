// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
//  1. START FROM LAST ROW OF THE MATIX THAT IS LAST HOUSE
//  2. NOW AS WE MOVE UP, FOR EACH HOUSE, STORE COLOR COST FOR THAT COLOUR PLUS PREVIOUS MINIMUM
//  EXCEPT THE SAME COLOR.
//  3. CAN USE 2D MATRIX AS WELL TO SAVE EVERY DATA, CAN YOU IDEX TO SAVE PATH.


class Solution {
    public int minCost(int[][] costs) {
        int n =costs.length;
        int redCost=costs[n-1][0];
        int blueCost = costs[n-1][1];
        int greenCost =costs[n-1][2];

        for(int i = n-2; i>=0;i--){
            int tempRed = redCost;
            redCost=Math.min(blueCost, greenCost)+costs[i][0];
            int tempBlue = blueCost;
            blueCost=Math.min(tempRed, greenCost)+costs[i][1];
            greenCost=Math.min(tempRed, tempBlue)+costs[i][2];
        }
        return Math.min(blueCost, Math.min(greenCost,redCost ));



        // int costRed = helper(costs, 0,0,0);
        // int costBlue = helper(costs, 0,1,0);
        // int costGreen = helper(costs, 0,2,0);
        // return Math.min(costRed, Math.min(costBlue, costGreen));

    }
    // private int helper(int [][] costs, int index, int colorIndex, int costTillNow){
    //     //base
    //     if(index==costs.length) return costTillNow;
    //     //logic
    //     //red
    //     if(colorIndex==0) return Math.min(helper(costs, index+1, 1, costTillNow+costs[index][colorIndex]),
    //     helper(costs, index+1, 2, costTillNow+costs[index][colorIndex]));
    //     //blue
    //     if(colorIndex==1) return Math.min(helper(costs, index+1, 0, costTillNow+costs[index][colorIndex]),
    //     helper(costs, index+1, 2, costTillNow+costs[index][colorIndex]));
    //     //green
    //     if(colorIndex==2) return Math.min(helper(costs, index+1, 0, costTillNow+costs[index][colorIndex]),
    //     helper(costs, index+1, 1, costTillNow+costs[index][colorIndex]));
    //     return 98;
    // }

}