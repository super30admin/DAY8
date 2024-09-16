
var minCost(costs) { 
    if(costs == null || costs.length == 0) return 0;
    var n = costs.length;
        for(i = 1;i<n;i++){
            costs[i][0] += Math.min(costs[i]-1[1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[n][0],costs[n][1],costs[n][2]);

     
}


//Time Complexity: O(mxn)
//Space Complexity : O(1)