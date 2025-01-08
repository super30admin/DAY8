// Time Complexity: O(n) as the loop is used to populate the min values
// Space Complexity: O(1) as no extra data structure is used.

// This is a bottom up Dynamic Programming approach. 
public class PaintHouse {

    public static void main(String[] args) {
        System.out.println(minCost(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } })); // 10
        System.out.println(minCost(new int[][] { { 7, 6, 2 } })); // 2
    }

    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int length = costs.length;

        // Loop starting from 2nd last(n-2) till 0 row.
        for (int i = length - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

}