//Time complexity : O(n)
//Space complexity: O(1)
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int red = costs[n-1][0]; //14
        int blue = costs[n-1][1]; //3
        int green = costs[n-1][2]; //19

        for(int i = n-2; i>=0; i--){
            int tempRed = red; 
            red = costs[i][0] + Math.min(blue, green);
            int tempBlue = blue;
            blue=costs[i][1] + Math.min(tempRed, green);
            green = costs[i][2] + Math.min(tempRed, tempBlue);
        }
        return Math.min(red, Math.min(blue, green));
    }
}