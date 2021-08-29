
// Lowest cost traversal painting non adj. collered houses

// Time Complexity : ( num of houses) 
// Space Complexity : 1
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this : No 
// Your code here along with comments explaining your approach

public class PainHouseDp {

    public int minCost(int[][] costs) {

        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args) {

    }
}
