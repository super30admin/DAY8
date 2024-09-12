//Time Complexity: O(n)
//Space Complexity: O(1)
//LeetCode: Yes

//Dynamic Programming by Mutate the input array
//Adding the minimum cost of the current with the minumum of the remaining columns of the previous row
//Minimum of the last row gives the answer



class Solution {
    public int minCost(int[][] costs) {
        //edge
        if(costs == null || costs.length ==0)return 0;
        
        int n = costs.length -1;
         for(int i=1;i<costs.length;i++){
             costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
             costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
             costs[i][2]+=Math.min(costs[i-1][0],costs[i-1][1]);
                 
         }
        return Math.min(costs[n][0],Math.min(costs[n][1],costs[n][2]));
    }
}