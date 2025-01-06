// Time Complexity : O(n^2) using brute force
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

var minCost = function(costs) {
    var row = costs.length,col=costs[0].length;
    for(var i=row-2;i>=0;i--){
        for(let j=0;j<col;j++){
            if(j==0){
                costs[i][j]+=Math.min(costs[i+1][j+1],cost[i+1][j+2]);
            }else if(j==1){
                costs[i][j]+=Math.min(costs[i+1][j-1],costs[i+1][j+1]);
            }else if(j==2){
                costs[i][j]+=Math.min(costs[i+1][j-1],costs[i+1][j-2]);
            }
        }
    }
    return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
};
console.log(minCost([[17,2,17],[16,16,5],[14,3,19]]));