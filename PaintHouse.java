// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
Explore all the paths, we cannot ignore any path. From all the paths find path which gives 
minima. I use a loop to iterate over all houses. Colors are columns and houses are rows. (n-1)th house will have the 
same cost as colors. For every house above that we find the minimun of color cost
for the next house and add into it. We find min of all the sums at the 0th row.
 */
public class PaintHouse {
    
    public int minCost(int[][] costs) {
        int n=costs.length;
        int red = costs[n-1][0];
        int blue = costs[n-1][1];
        int green = costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int tred=red;
            red=costs[i][0]+Math.min(blue,green);
            int tblue=blue;
            blue=costs[i][1]+Math.min(tred,green);
            green=costs[i][2]+Math.min(tred,tblue);
        }
        return Math.min(red,Math.min(blue,green));
    }
}
