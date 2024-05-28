// Time Complexity : O(m*n) => As we are creating a 2D matrix and travesing through all the rows(m) and all the columns(n)
// Space Complexity : O(1) => As we are storing the result in the 2D matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Started from the 2nd last row and adding the cost of that cell with the min cost from the next row (excluding adjacent cell). In the last iteration, first row will have sum of all the houses.
 */
// class Solution {
//     public int minCost(int[][] costs) {

//         for (int i = costs.length - 2; i >= 0; i--) {
//             costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
//             costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
//             costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
//         }

//         return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
//     }
// }

// =========================Approach 2 (Without mutating original matrix) ========================
// Time Complexity : O(m*n) => As we are creating a 2D matrix and travesing through all the rows(m) and all the columns(n)
// Space Complexity : O(m*n) => We are creating a new dp matrix which will occupy m*n space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Create a new 2D matrix and the copy the last row from the costs matrix and then traverse from bottom to up by adding the minimum value from next row
 */
// class Solution {
//     public int minCost(int[][] costs) {

//         int dp[][] = new int[costs.length][3];

//         for (int i = 0; i < 3; i++) {
//             dp[costs.length - 1][i] = costs[costs.length - 1][i];
//         }

//         for (int i = costs.length - 2; i >= 0; i--) {
//             dp[i][0] = costs[i][0]+ Math.min(dp[i + 1][1], dp[i + 1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
//         }
//         return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
//     }
// }

//======================== Top to Bottom ==========================
// class Solution {
//     public int minCost(int[][] costs) {

//         for(int i =1 ; i<costs.length; i++){
//             costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
//             costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
//             costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
//         }

//         return Math.min(costs[costs.length -1][0], Math.min(costs[costs.length-1][1],costs[costs.length -1][2]));
//     }
// }

// Time Complexity : O(m*n) => As we are creating a 2D matrix and travesing through all the rows(m) and all the columns(n)
// Space Complexity : O(1) => As we are storing the result in the 2D matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Stored values in temp variables instead of mutating the existing costs matrix or creating a new matrix
 */
class Solution {
    public int minCost(int[][] costs) {

        int red = costs[costs.length - 1][0];
        int blue = costs[costs.length - 1][1];
        int green = costs[costs.length - 1][2];

        for (int i = costs.length - 2; i >= 0; i--) {

            int tempRed = red;
            int tempBlue = blue;
            red = costs[i][0] + Math.min(tempBlue, green);
            blue = costs[i][1] + Math.min(tempRed, green);
            green = costs[i][2] + Math.min(tempRed, tempBlue);
        }

        return Math.min(red, Math.min(blue, green));
    }
}

//This solution uses 0-1 recursion

// class Solution {
//     public int minCost(int[][] costs) {

//         int red = minCostToPaint(costs, 0, 0, 0);
//         int blue = minCostToPaint(costs, 0, 1, 0);
//         int green = minCostToPaint(costs, 0, 2, 0);

//         return Math.min(red, Math.min(blue, green));
//     }

//     private int minCostToPaint(int[][] costs, int row, int column, int minCost) {

//         if (row == costs.length) {
//             return minCost;
//         }

//         if (column == 0) {
//             return Math.min(minCostToPaint(costs, row + 1, 1, minCost + costs[row][column]),
//                     minCostToPaint(costs, row + 1, 2, minCost + costs[row][column]));
//         } else if (column == 1) {
//             return Math.min(minCostToPaint(costs, row + 1, 0, minCost + costs[row][column]),
//                     minCostToPaint(costs, row + 1, 2, minCost + costs[row][column]));
//         } else {
//             return Math.min(minCostToPaint(costs, row + 1, 0, minCost + costs[row][column]),
//                     minCostToPaint(costs, row + 1, 1, minCost + costs[row][column]));
//         }
//     }

// }