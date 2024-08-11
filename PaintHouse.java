public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        // Space - O(1) because we are mutating the same matrix.
        // time = o(n) because colors are constant. not mXn.
        // if not ok to mutate original matrix, we can use DP matrix.
        //copy last row from cossts and copy all three elemets and and calculate as in this existing.
        // calculate the length of an array.
        int n = costs.length;

        // starting from last but 1 row as we pick from the last row.
        // can also start from second from the top.

        // if we pick one color that is col 0,
        //in next row we pick min of col 1 or col 2 and store it in each col for each row.
        // at the end we return min of al lthreee costs fro mrow 1.

        for (int i = n - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
