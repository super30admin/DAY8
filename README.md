# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)

# TC SC - O(n*n)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        house_cost = {}
        def dfs(i, curr_color_idx):
            if i == len(costs):
                return 0
            
            if (i, curr_color_idx) in house_cost:
                return house_cost[(i, curr_color_idx)]

            if curr_color_idx == 0:
                option_1 = dfs(i+1,1) + costs[i][1] # paint green
                option_2 = dfs(i+1,2) + costs[i][2] # paint blue
            
            elif curr_color_idx == 1:
                option_1 = dfs(i+1,0) + costs[i][0] # paint red
                option_2 = dfs(i+1,2) + costs[i][2] # paint blue
            
            else:
                option_1 = dfs(i+1,0) + costs[i][0] # pain red
                option_2 = dfs(i+1,1) + costs[i][1] # paint green
            
            res = min(option_1,option_2) # pick the recursive path with minimum sum

            house_cost[(i, curr_color_idx)] = res  # cache the result (memoization)

            return house_cost[(i,curr_color_idx)]

        start_red = dfs(1,0) + costs[0][0]
        start_green = dfs(1,1) + costs[0][1]
        start_blue = dfs(1,2) + costs[0][2]
        res = min(start_red,start_green,start_blue) # minimum of the three possible paths
        return res       

## Problem2 (https://leetcode.com/problems/coin-change-2/)

# TC SC - O(n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        cache={}
        def dfs(i,k):
            if (i,k) in cache:
                return cache[(i,k)]
            if i>len(coins)-1:
                cache[(i,k)]=0
                return 0
            if k<0:
                cache[(i,k)]=0
                return 0
            if k==0:
                cache[(i,k)]=1
                return 1
            take = dfs(i,k-coins[i])
            ntake = dfs(i+1,k)
            
            cache[(i,k)]=take+ntake
            return take+ntake
        
        return dfs(0,amount)

