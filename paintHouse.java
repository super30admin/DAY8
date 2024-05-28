class Solution {
    public int minCost(int[][] costs) {

        int red = costs[costs.length - 1][0];
        int blue = costs[costs.length - 1][1];
        int green = costs[costs.length - 1][2];

        for (int i = costs.length - 2; i >= 0; i--) {

            int tempRed = red;
            int tempBlue = blue;
            red = costs[i][0] + Math.min(tempBlue, green);
            blue = costs[i][1] + Math.min(tempRed, green);
            green = costs[i][2] + Math.min(tempRed, tempBlue);
        }

        return Math.min(red, Math.min(blue, green));
    }
}