// Time Complexity: O(n), where n is the number of houses.
// Space Complexity: O(1), constant space is used.
// Approach: Dynamic Programming - Bottom-Up approach. Starting from the last house, calculate the minimum cost of painting each house based on the costs of painting the next house. At each house, calculate the minimum cost of painting it with either red, blue, or green based on the costs of painting the next house with different colors. Return the minimum cost among the three options.
// leetcode link: (https://leetcode.com/problems/paint-house/)

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;

        int costR = costs[n-1][0];
        int costB = costs[n-1][1];       
        int costG = costs[n-1][2];

        for(int i = n-2; i>=0; i--)
        {
            int tempR = costR;
            costR = costs[i][0] + Math.min(costB, costG);
            int tempB= costB;
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(costG , Math.min(costR, costB));
    }
}
