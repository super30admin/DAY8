// Time Complexity : O(3n) => O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First applied recursive solution and then applied bottom-to-top solution with 2D array for solving issue as taught in class.
/**
 * @param {number[][]} costs
 * @return {number}
 */
var minCost = function(costs) {
    
    for(let i=costs.length-2; i>=0; i--){
        for(let j=0; j<3; j++){
            if(j == 0)
                costs[i][0] = Math.min(costs[i][0]+costs[i+1][1],
                        costs[i][0]+costs[i+1][2] )
            if(j == 1)
                costs[i][1] = Math.min(costs[i][1]+costs[i+1][0],
                        costs[i][1]+costs[i+1][2] )
            if(j == 2)
                costs[i][2] = Math.min(costs[i][2]+costs[i+1][0],
                        costs[i][2]+costs[i+1][1] )
        }
    }

    return Math.min(costs[0][0], costs[0][1], costs[0][2]);
};