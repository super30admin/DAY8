/**
 L.C:256 Paint House
 Approach: Dynamic programming using the given matrix
 Working: iterating fro the second last row, choosing the min value colour other than the current color and storing the
          value in the current cell i,j till we reach the oth index row

           return computing the min value in the 0th index row value

 Time Complexity:O(n)
 Space Complexity: O(1) // no extra space used
 */

class PaintHouse {
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0){
            return 0;
        }

        for(int i=costs.length-2; i>=0;i--) {
            costs[i][0] = costs[i][0]+Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1]+ Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2]+ Math.min(costs[i+1][0], costs[i+1][1]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

    }
}