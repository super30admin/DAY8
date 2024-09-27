class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        def coinChange(i, A, coins):
            #base case
            if i == 0: 
                if A % coins[i] == 0: return 1
                return 0
            

            if dp[i][A] != -1: return dp[i][A]
            notTake = 0 + coinChange(i-1, A, coins)

            take = 0
            if coins[i] <= A:
                take = coinChange(i, A-coins[i], coins)
            

            dp[i][A] = (notTake + take)
            return (notTake + take)
        
        n = len(coins)
        dp = [[-1] * (amount+1) for _ in range(n)]

        return coinChange(n-1, amount, coins)