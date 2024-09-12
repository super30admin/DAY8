//This solution has complexity of O(n) where is the number of houses which is the row
// and has a space complexity of O(1) as we dont use any addiotional space
class Solution {
  public int minCost(int[][] costs) {
    if(costs.length == 0)
      return 0;
    int n = costs.length;
    //We loop through the row and add min cost to each column find the previous minimum price of other two colors
    for(int i=1;i<n;i++){
      costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
      costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
      costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
    }
    //final array contains the cumlative cost calculated we find the min of those
    return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
  }
}