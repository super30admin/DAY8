# time complexity: O(n)
# space complexity: O(n)
def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount+1)  # initiate dp
        dp[0] = 1
        for i in coins:
            for j in range(i, amount+1):
                dp[j] += dp[j-i]
        return dp[amount]