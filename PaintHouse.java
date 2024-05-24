class PaintHouse {

    //Using DP bottom up approach and temp variable to store intermediate results
    //TC - O(n), SC - O(1)
    public int minCost(int[][] costs) {
        // Edge case: If costs is null or has no houses.
        if(costs == null || costs.length == 0)
            return 0;

        int n = costs.length;

        //Initialize each color variable with the cost associated with the last row
        int red = costs[n-1][0];
        int blue = costs[n-1][1];
        int green = costs[n-1][2];

        //starting with n-2 row
        for(int i = n-2; i>=0; i--) {
            int tempRed = red;
            red = costs[i][0] + Math.min(blue, green);  //choosing color red for current row
            int tempBlue = blue;
            blue = costs[i][1] + Math.min(tempRed, green);  //choosing color blue for current row
            green = costs[i][2] + Math.min(tempRed, tempBlue);  //choosing color green for current row
        }

        return Math.min(red, Math.min(blue, green));
    }
}
