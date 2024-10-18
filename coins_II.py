class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

      if coins == None or len(coins)== 0:
        return 0
      #   0 1 2 3 4 5
      # 0 1 0 0 0 0 0
      # 1 1 1 1 1 1 1
      # 2 1 1 2 2 3 3
      # 5 1 1 2 2 3 4

      # 1,2 -> 2 my pointer is at 2

      # case 0: [1,2,5](5) -> [1,2](5) = 3  
      # case 1: [1,2,5](5) -> [1,2,5](0) = 

      n = len(coins)+1
      m = amount +1
      dp = [[0] * (amount +1) for i in range(n)] 

      for i in range(n):
        dp[i][0] = 1
      

      for i in range(1,n):
        for j in range(1,amount+1):
          if j < coins[i-1]:
            dp[i][j] = dp[i-1][j]
          else:
            dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
      
      return dp[n-1][amount]


    
    
    # Recursive approach
    #   return self.recurse(coins, amount, 0)
    
    # def recurse(self, coins:list[int], amount:int, index: int) -> int:
    #   # base
    #   if amount < 0 or index == len(coins):
    #     return 0
    #   if amount == 0:
    #     return 1

    #   # logic
    #   case0 = self.recurse(coins, amount, index+1)
    #   case1 = self.recurse(coins, amount-coins[index], index)

    #   return case0 + case1



      