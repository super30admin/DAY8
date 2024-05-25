//Time complexity : O(n) where n is the number of houses
//Space complexity: O(1) as we are using constant space 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null){
            return -1;
        }

        
        int n = costs.length;
        
        //red, blue, green cost of the last house
        int red = costs[n-1][0];
        int blue = costs[n-1][1];
        int green = costs[n-1][2];

        //start from the second last row and keep adding the minimum cost of the next row to the current row
        for(int i = n-2; i >=0; i--){
            int tempRed = red;
            red = costs[i][0] + Math.min(blue,green);
            int tempBlue = blue;
            blue = costs[i][1] + Math.min(tempRed,green);
            int tempGreen = green;
            green = costs[i][2] + Math.min(tempRed,tempBlue);
        }

        //return the minimum cost of the first row  
        return Math.min(red, Math.min(blue,green));
        
    }
}