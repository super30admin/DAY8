// Problem:
// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on… Find the minimum cost to paint all houses.
// Note: All costs are positive integers.

// Examples:
// Input: [[17,2,17],[16,16,5],[14,3,19]]
// Output: 10
// Input: []
// Output: 0

// #############################################################
// Approach 1: Recursion + Memoization
// TC: O(n), where n is the number of houses
// SC: O(n)

// Approach 2: Tabulation with O(1) space
// TC: O(n), where n is the number of houses
// SC: O(1)
// #############################################################


// Approach 1: Recursion + Memoization
import java.util.Arrays;

public class LC256 {
    private static int minCost(int costs[][], int i, int n, int prev, int[][] dp) {
        if (i == n - 1) {
            int m = Integer.MAX_VALUE;
            for (int x = 0; x < 3; x++) {
                if (x != prev)
                    m = Math.min(m, costs[i][x]);
            }
            return m;
        }
        if (dp[i][prev] != -1)
            return dp[i][prev];
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < 3; x++) {
            if (x != prev) {
                dp[i][x] = min = Math.min(min, costs[i][x] + minCost(costs, i + 1, n, x, dp));
            }
        }
        return min;
    }
    // private static void printArray(int dp[][]){
    //     for(int x[]:dp){
    //         System.out.println(Arrays.toString(x));
    //     }
    // }
    public static void main(String[] args) {
        int costs[][] = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        int n = costs.length;
        if (n == 0)
            System.out.println("Minimum cost to paint all houses: "+ 0);
        else {
            int dp[][]=new int[n][4];
            for(int x[]:dp){
                Arrays.fill(x, -1);
            }
            int ans = minCost(costs, 0, n, 3, dp);
            // printArray(dp);
            System.out.println("Minimum cost to paint all houses: " + ans);
        }
    }
}

// Approach 2: Tabulation with O(1) space
class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int x = 0; x < 3; x++) {
                int min = Integer.MAX_VALUE;
                for (int y = 0; y < 3; y++) {
                    if (x != y)
                        min = Math.min(min, A[i + 1][y]);
                }
                A[i][x] += min;
            }
        }
        return Math.min(A[0][2], Math.min(A[0][1], A[0][0]));
    }
}
