import java.util.*;
public class PaintHouse {
    private int[][] costs;
    private Map<String, Integer> memo;

    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int red = costs[n - 1][0], blue = costs[n - 1][1], green = costs[n - 1][2];
        for (int i = n-2; i >= 0; i--) {
            int tempRed = red;
            int tempblue = blue;
            // Total cost of painting the nth house red.
            red = costs[i][0] + Math.min(blue, green);
            // Total cost of painting the nth house green.
            blue =  costs[i][1] + Math.min(tempRed, green);
            // Total cost of painting the nth house blue.
            green =  costs[i][2] + Math.min(tempRed, tempblue);
        }

        return Math.min(Math.min(red, blue), green);
    }

    public int minCost4(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        for(int j = 0; j < 3; j++){
            dp[n - 1][j] = costs[n-1][j];
        }
        for (int i = n-2; i >= 0; i--) {
            // Total cost of painting the nth house red.
            dp[i][0] += costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            // Total cost of painting the nth house green.
            dp[i][1] +=  costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            // Total cost of painting the nth house blue.
            dp[i][2] +=  costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }

    public int minCost3(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;

        for (int i = n-2; i >= 0; i--) {
            // Total cost of painting the nth house red.
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            // Total cost of painting the nth house green.
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            // Total cost of painting the nth house blue.
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }

    public int minCost2(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        this.memo = new HashMap<>();
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) {
        if (memo.containsKey(getKey(n, color))) {
            return memo.get(getKey(n, color));
        }
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        memo.put(getKey(n, color), totalCost);

        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
    public static void main(String[] strs){
        int ans = new PaintHouse().minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}});
        System.out.println(ans);
    }
}
