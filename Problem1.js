//Paint House (LC 256)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes but some fail.
// Any problem you faced while coding this : Yes coming up with DP was tough

//Did brute force which didn't work, then did recursive but it would time out, added memoize and it is a bit better but doesn't work fully.
/**
 * @param {number[][]} costs
 * @return {number}
 */
var minCost = function(costs) {
    if(costs.length === 0 || costs === null){
        return 0;
    }
    let minSum = 0;
    let memo = new Map();
    function helper(n, color){
        if(memo.has(n+color)){
            return memo.get(n+color);
        }
        let totalCost = costs[n][color];
        if(n === costs.length - 1){

        } else if(color === 0){
            totalCost += Math.min(helper(n+1,1),helper(n+1,2));
        } else if(color === 1){
            totalCost += Math.min(helper(n+1,0),helper(n+1,2));
        } else {
            totalCost += Math.min(helper(n+1,0),helper(n+1,1));
        }
        memo.set(n+color,totalCost);
        return totalCost;
    }
    
    minSum = Math.min(helper(0,0),helper(0,1),helper(0,2));
    return minSum;
};