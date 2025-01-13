//TC: O(n)
//SC: O(1)
//approach: dynamic programming
public class PaintHouse {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length;

        int prevRed = costs[0][0];
        int prevBlue = costs[0][1];
        int prevGreen = costs[0][2];

        for (int i = 1; i < n; i++) {
            int currRed = costs[i][0] + Math.min(prevBlue, prevGreen);
            int currBlue = costs[i][1] + Math.min(prevRed, prevGreen);
            int currGreen = costs[i][2] + Math.min(prevRed, prevBlue);

            prevRed = currRed;
            prevBlue = currBlue;
            prevGreen = currGreen;
        }

        return Math.min(prevRed, Math.min(prevBlue, prevGreen));
    }
}
