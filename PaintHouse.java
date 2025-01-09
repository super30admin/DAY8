/* Description: Here, while observing recursion tree, we get that there are many repeated subproblems. So using DP.
There is 1 decision making factor, when we are out of houses. In this type of DP problems, we start from n-2 row and go till 0th row. 
At each position, we try to look at the next row and take the one that is min and add it to the current value. So, when we are at third
last row, we dont have to go till the bottom again, we have our values in the next row itself.*/
// Time Complexity : O(n) - where n is the number of houses(it is n*3 but 3 is constant number of colors)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : premium
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
// Brute force which is failing with time limit exceeded
class PaintHouse {
    public int minCost(int[][] costs) {
        // Base case:
        if (costs == null || costs.length == 0) {
            return 0;
        }
        // Three cases, one when we start by picking red color for first house, second
        // blue, and third green
        int costRed = recurse(costs, 0, 0, 0);
        int costBlue = recurse(costs, 0, 1, 0);
        int costGreen = recurse(costs, 0, 2, 0);
        // Return min of three
        return Math.min(costRed, Math.min(costGreen, costBlue));

    }

    private int recurse(int[][] costs, int row, int col, int costIncurred) {
        // Base case
        // When we are out of houses
        if (row == costs.length) {
            return costIncurred;
        }
        // Logic
        // Suppose, if decide to pick red first i.e. col=0, then from next row we can
        // pick min from col=1 and col=2
        if (col == 0) {
            return Math.min(recurse(costs, row + 1, 1, costIncurred + costs[row][col]),
                    recurse(costs, row + 1, 2, costIncurred + costs[row][col]));
        }
        // Suppose, if decide to pick blue first i.e. col=1, then from next row we can
        // pick min from col=0 and col=2
        else if (col == 1) {
            return Math.min(recurse(costs, row + 1, 0, costIncurred + costs[row][col]),
                    recurse(costs, row + 1, 2, costIncurred + costs[row][col]));
        }
        // Suppose, if decide to pick green first i.e. col=2, then from next row we can
        // pick min from col=0 and col=1
        else {
            return Math.min(recurse(costs, row + 1, 0, costIncurred + costs[row][col]),
                    recurse(costs, row + 1, 1, costIncurred + costs[row][col]));
        }
    }

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        System.out.println(paintHouse.minCost(costs));
    }
}

class PaintHouse2 {
    public int minCost(int[][] costs) {
        // Base condition
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        // Starting from second last row
        for (int i = n - 2; i >= 0; i--) {
            // Red color case
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
            // Blue color case
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            // Green color case
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][1], costs[i + 1][0]);
        }
        // Min of first row
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args) {
        PaintHouse2 paintHouse2 = new PaintHouse2();
        int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        System.out.println(paintHouse2.minCost(costs));
    }
}
