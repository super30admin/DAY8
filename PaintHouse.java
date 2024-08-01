// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
public class PaintHouse {
    public static int paintCosts(int[][] costs) {
        int houses = costs.length;
        int[][] dp = new int[houses][3];
        dp[houses-1][0] = costs[houses-1][0];
        dp[houses-1][1] = costs[houses-1][1];
        dp[houses-1][2] = costs[houses-1][2];

        for(int i=houses-2; i>=0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0] , Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String[] args) {
        int[][] costs1 = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("The minimum cost of painting houses with given costs1 is " + paintCosts(costs1));

        int[][] costs2 = {{13,5,29},{14,15,17},{21,4,16},{12,11,8},{9,19,10}};
        System.out.println("The minimum cost of painting houses with given costs2 is " + paintCosts(costs2));
    }
}