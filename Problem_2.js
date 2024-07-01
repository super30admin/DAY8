// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First applied recursive solution and then applied bottom-to-top solution with 2D array for solving issue as taught in class.
/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */


var change = function (amount, coins) {
    //var memo = new Map();
    // //Recursion method with memoization
    // var changeHelper = (amount, coins, index, memo) => {
    //         if(amount < 0 || index == coins.length) return 0;
    //         if(amount == 0) return 1;
    //         if(memo.has(index+'-'+amount)) return memo.get(index+'-'+amount);

    //         let count1 = changeHelper(amount-coins[index], coins, index, memo)
    //         let count2 = changeHelper(amount, coins, index+1, memo)

    //         memo.set(index+'-'+amount, count1+count2);
    //         return memo.get(index+'-'+amount);
    // }

    // return changeHelper(amount, coins, 0, memo);
    let dp = new Array(coins.length + 1).fill(Array(amount + 1).fill(0));

    dp[0][0] = 1;
    for (let i = 1; i <= coins.length; i++) {
        dp[i][0] = 1;
    }
    for (let i = 1; i <= coins.length; i++) {
        for (let j = 1; j <= amount; j++) {
            if (coins[i - 1] > j) {
                dp[i][j] = dp[i - 1][j];
            }
            else {
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
    }
    return dp[coins.length][amount];
};

