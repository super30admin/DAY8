// Time Complexity : n^m
// Space Complexity : n^m
// Did this code successfully run on Leetcode : No. Time limit exceeded
// Any problem you faced while coding this : wrong answer for test case 0 amount and empty coins[]


// Your code here along with comments explaining your approach
//Recursive approach to choose and not choose a coin then add the two cases to get the possible combination count to make given amount

class Solution {
    func change(_ amount: Int, _ coins: [Int]) -> Int {
        return helper(amount,coins,0)
    }
    
    private func helper(_ amount: Int, _ coins: [Int],_ startIndex: Int) -> Int {
        //base case
        if amount == 0 {
            return 1
        }
        if amount < 0 || startIndex >= coins.count{
            return 0
        }
    
        //logic
        //not choose a coin
        let case1 = helper(amount, coins, startIndex + 1)
        
        //choose a coin
        let case2 = helper(amount-coins[startIndex],coins, startIndex)
        //result
        
        return case1 + case2
         
    }
}

//DP solution
// Time Complexity : n*m
// Space Complexity : n*m
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes little confused with row and column

class Solution {
    func change(_ amount: Int, _ coins: [Int]) -> Int {
        var dp = [[Int]](repeating: [Int](repeating:0, count: amount+1), count: coins.count+1)
        //first row should be zero
        for i in 0..<dp[0].count {
            dp[0][i] = 0
        }
        //first column should be zero
        for i in 0..<dp.count {
            dp[i][0] = 1
        }
        for i in 1..<dp.count {
            for j in 1..<dp[0].count {
                if j < coins[i-1]{
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                }
            }
        }
        return dp[coins.count][amount]
    }
    
}
