/**
 * Time Complexity: O(n) where n is rows/houses and 3 is constant
 * Space complexity: O(1) using only 3 variables for additional space
 * Ran on leetcode? Yes
 * Any problems faced?: No
 *
 * We pick one house and get the costs from the bottom up
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // Variables to store the cost of painting the next house
        int nextRed = costs[costs.length - 1][0];
        int nextBlue = costs[costs.length - 1][1];
        int nextGreen = costs[costs.length - 1][2];

        // Iterate from the second-to-last house to the first house
        for (int i = costs.length - 2; i >= 0; i--) {
            int currentRed = costs[i][0] + Math.min(nextBlue, nextGreen);
            int currentBlue = costs[i][1] + Math.min(nextRed, nextGreen);
            int currentGreen = costs[i][2] + Math.min(nextRed, nextBlue);

            // Update the next house costs
            nextRed = currentRed;
            nextBlue = currentBlue;
            nextGreen = currentGreen;
        }

        // Return the minimum cost to paint
        return Math.min(nextRed, Math.min(nextBlue, nextGreen));
    }

    public static void main(String[] args) {
        PaintHouse obj = new PaintHouse();
        int[][] costs = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        int minCost = obj.minCost(costs);
        System.out.println("Result: " + minCost);
        assert(minCost == 10);
    }
}
