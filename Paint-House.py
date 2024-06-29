# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : I initially sketched the incorrect treee. I followed the same approach of coin change but this
#  problem had a different approach

def minCost(self, costs: List[List[int]]) -> int:
        n=len(costs)

        dp=[[0 for i in range(3)] for j in range(len(costs))]
        #base case fillling the values for initial case
        dp[n-1][0]=costs[n-1][0]
        dp[n-1][1]=costs[n-1][1]
        dp[n-1][2]=costs[n-1][2]

        #calculating the values based on the current color
        for i in range(n-2,-1,-1):
            dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2])
            dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2])
            dp[i][2]=costs[i][2]+min(dp[i+1][1],dp[i+1][0])
        print(dp)
        #returning the minimum cost of the painting based on the starting color.
        return min(dp[0][0],dp[0][2],dp[0][1])
        
        # recursive code
        # def helper(costs,r,c):
        #     if r==len(costs):
        #         return 0
        #     if c==0:
        #         return costs[r][0]+min(helper(costs,r+1,1),helper(costs,r+1,2))
        #     if c==1:
        #         return costs[r][1]+min(helper(costs,r+1,0),helper(costs,r+1,2))
        #     if c==2:
        #         return costs[r][2]+min(helper(costs,r+1,0),helper(costs,r+1,1))
            
        # redColor=helper(costs,0,0)
        # blueColor=helper(costs,0,1)
        # greenColor=helper(costs,0,2)
        # return min(redColor,blueColor,greenColor)


#Approach:
# similar to what is taught in the class.

# after reading the problem i came to know that there are fix number of colors i.e 3 and also
# if we select one color from the current row we cannot select the same color in the next row.
# i.e we have to select from remaining 2 colors.

# After this i tried greedy but when the values are to extreme it will fail. because we are not knowing which
# path will yeild us the smallest result.

# then i explored all the paths by being exhaustive for each color. when drawing the trees i came to know that there 
# are repeated subtrees in this and we can stroe and reuse the result for the repeated subproblem.

# hence i solved the problem using dp
