// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


/*
 * Exhaustive approach - since greedy didnt work
 */
public class HouseRobberRecursive{
    public int minCost(int[][] costs) {
        int houseIndex=0;
        int chooseR=  helper(costs, houseIndex, 0, 0);
        int chooseB =  helper(costs, houseIndex, 1, 0);
        int chooseG = helper(costs, houseIndex, 2, 0);

        return Math.min(chooseB, Math.min(chooseG, chooseR));
    }

    private int helper(int[][] costs, int i, int color, int totalAmount){

        //base case
        if (i>= costs.length) return totalAmount;

        //logic
        if(color==0){ // RED
            int chooseB = helper(costs, i+1, 1, totalAmount+costs[i][color]);
            int chooseG =helper(costs, i+1, 2, totalAmount+costs[i][color]);
            totalAmount = Math.min(chooseB, chooseG);
        }else if(color==1){ // Blue
            int chooseB = helper(costs, i+1, 0, totalAmount+costs[i][color]);
            int chooseG =helper(costs, i+1, 2, totalAmount+costs[i][color]);
            totalAmount = Math.min(chooseB, chooseG);
        }else{
            //Green
            int chooseB = helper(costs, i+1, 1, totalAmount+costs[i][color]);
            int chooseG =helper(costs, i+1, 0, totalAmount+costs[i][color]);
            totalAmount = Math.min(chooseB, chooseG);
        }

        return totalAmount;
    }
}