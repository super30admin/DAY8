i// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach
/*
1. In brute force manner At every house we have two choices. if first house is red then next house we can color either green or blue. if first house we colored blue next house we can color either green or red.. so on. So we will be observing all the paths

Dynamic programming
1. we start from 2nd house. if we choose to color this house as red then we should have colored 1st house as blue or green. So cost of coloring this house would be cost of coloring this house as red plus minimum price of coloring prev house as green or blue.
*/
class Solution {
    public int minCost(int[][] costs) {
        //base case
        if(costs == null || costs.length ==0)
            return 0;
        int row = costs.length;
        for(int i=1; i<costs.length; i++){
            costs[i][0]= costs[i][0]+ Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]= costs[i][1]+ Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]= costs[i][2]+ Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[row-1][0], Math.min(costs[row-1][1],costs[row-1][2]));
    }
}
