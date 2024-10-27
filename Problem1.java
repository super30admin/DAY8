// PROBLEM 1: Paint house
/*
Time Complexity : Exponential | O(2^N) [Since there are only 3 options in color]
Space Complexity : O(3 * N) = O(N) [Call stack/ Height of Tree]
Did this code successfully run on Leetcode : Yes, but TLE because TC is very high
                                             (27 / 100 testcases passed)
Any problem you faced while coding this : No
*/

/* Exhaustive Approach
class Problem1 {
    public int minCost(int[][] costs) {
        // null case
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        return helper(costs, 0, -1, 0);
    }
    private int helper(int[][] costs, int houseNumber, int prevColor, int cost){
        // base
        if(houseNumber == costs.length) return cost;

        // logic
        if(prevColor == 0){
            int pathBlue = helper(costs, houseNumber + 1, 1, cost + costs[houseNumber][1]);
            int pathGrn  = helper(costs, houseNumber + 1, 2, cost + costs[houseNumber][2]);
            return Math.min(pathBlue, pathGrn);
        }
        else if(prevColor == 1){
            int pathRed = helper(costs, houseNumber + 1, 0, cost + costs[houseNumber][0]);
            int pathGrn = helper(costs, houseNumber + 1, 2, cost + costs[houseNumber][2]);
            return Math.min(pathRed, pathGrn);
        }
        else if(prevColor == 2){
            int pathRed = helper(costs, houseNumber + 1, 0, cost + costs[houseNumber][0]);
            int pathBlue = helper(costs, houseNumber + 1, 1, cost + costs[houseNumber][1]);
            return Math.min(pathRed, pathBlue);
        }
        else{
            int pathRed = helper(costs, houseNumber + 1, 0, cost + costs[houseNumber][0]);
            int pathBlue = helper(costs, houseNumber + 1, 1, cost + costs[houseNumber][1]);
            int pathGrn = helper(costs, houseNumber + 1, 2, cost + costs[houseNumber][2]);
            int tmpMin = Math.min(pathRed, pathBlue);
            return Math.min(tmpMin, pathGrn);
        }
    }
}
*/

//---------------------------------------Solution 1 ENDS HERE-----------------------------------------------

/*
Time Complexity : O(N*M)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Did it myself but weirdly took too long. (41 mins)
*/

/* DP approach*/

class Problem1 {
    public int minCost(int[][] costs) {
        // Initial DP solution
        // null case
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = costs.length - 2; i >= 0; i--){
            /* Compare with every element
            except same color below in next row.
            Keeps storing the best case up to that level.
            Last row is already at its best. */

            for(int j = 0; j < costs[0].length; j++){
                costs[i][j] += minFromNextRow(costs, i, j);
            }
        }
        // Min cost of painting houses is smallest in top row.
        for(int i = 0; i < costs[0].length; i++){
            ans = Math.min(ans, costs[0][i]);
        }
        return ans;

    }
    /*Find the minimum cost of next row except right below. */

    private int minFromNextRow(int[][] costs, int row, int col){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < costs[0].length; i++){
            if(i == col) continue;
            min = Math.min(min, costs[row + 1][i]);
        }
        return min;
    }
}

//--------------------------------------Solution 2 ENDS HERE-----------------------------------------------
