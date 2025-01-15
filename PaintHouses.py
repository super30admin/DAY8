class PaintHouse:
    
    #Time Complexity = O(m *3)
                    #i.e  O(m)
    def minCost(self, houses : list[int]) -> int:
        houses = [[1,2,4] [13,4,21] [8,12,19]]
        m = len(houses)    
        dp = [[0] *(3)] * len(houses)
    
    
        if(len(houses) == 0 or houses ==None):
            dp = 0
    
        for i in range(2):
            dp[0][i] = houses[i][0]
        
        for i in range(1,m):
            for j in range(len(3)):
                if(j==0 & i != m):
                    dp[i][j] == min(dp[i+1][j+1], dp[i+1][j+2]) + houses[i][0]
                elif(j==1 & i != m):
                    dp[i][j] == min(dp[i+1][j-1], dp[i+1][j+1]) + houses[i][0]
                elif(j==2 & i != m):
                    dp[i][j] == min(dp[i+1][j-1], dp[i+1][j-2]) ++ houses[i][0]
        return min(dp[m-1][0]) ,dp[m-1][1],dp[m-1][2]
        
    
                
                
            
        
        