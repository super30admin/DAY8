package paintHouse;

//top down approach

// Time Complexity : logrithmic Thus, the worst-case time complexity is **O(2 ^n) since at each step, the function makes two calls per color, leading to an exponential growth in the number of recursive calls.
// Space Complexity : the space complexity is O(n) due to recursive stack usage.
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded exception

public class Recursive {

    public static void main(String[] args) {

//        int[][] costs = {{17,2,17}, {16,16,5},{14,3,19}};
        int[][] costs = {{7,6,2}};

        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {

        int reR = helper(costs, 0, 0);
        int reB = helper(costs, 1, 0);
        int reG = helper(costs, 2, 0);

        return Math.min(reR, Math.min(reB, reG));
    }

    /**
     j: color
     i: house of index
     */
    private static int helper(int[][] costs, int j, int i) {

        // base

        if(i == costs.length) {
            return 0;
        }

        // logic

        // red
        if(j == 0) {
            // blue
            int res1 = helper(costs, 1, i+1);

            // green
            int res2  = helper(costs, 2, i+1);

            return costs[i][0] + Math.min(res1, res2);
        }

        // blue
        if(j == 1) {
            // red
            int res1 = helper(costs, 0, i+1);

            // green
            int res2  = helper(costs, 2, i+1);

            return costs[i][1] + Math.min(res1, res2);
        }

        // green
        if(j == 2) {
            // red
            int res1 = helper(costs, 0, i+1);

            // blue
            int res2  = helper(costs, 1, i+1);

            return costs[i][2] + Math.min(res1, res2);
        }

// dummy value
        return 1000;
    }
}
