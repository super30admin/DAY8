# Time Complexity - O(n)
# Space Complexity - O(1)

def minCost(costs): 
    for i in range(1,len(costs)): 
        costs[i][0]=costs[i][0]+min(costs[i-1][1],costs[i-1][2]) 
        costs[i][1]=costs[i][1]+min(costs[i-1][0],costs[i-1][2]) 
        costs[i][2]=costs[i][2]+min(costs[i-1][1],costs[i-1][0]) 
    return min(costs[len(costs)-1][1],costs[len(costs)-1][0],costs[len(costs)-1][2])

# Time Complexity - O(n)
# Space Complexity - O(n)
def main(cost):
    if len(cost)==0:
        return 0
    dp = [[0 for j in range(3)] for i in range(len(cost))]
    dp[0][:] = cost[0][:]
    for i in range(1,len(cost)):
        #choose red
        dp[i][0] = cost[i][0]+min(dp[i-1][1],dp[i-1][2])
        #choose blue
        dp[i][1] = cost[i][1]+min(dp[i-1][0],dp[i-1][2])
        #choose green
        dp[i][2] = cost[i][2]+min(dp[i-1][0],dp[i-1][1])
    return min(dp[-1][:])

cost = [[17, 2, 1],[1,16,1],[14,3,19],[3,1,8]]
print(main(cost))

'''
# Time Complexity - O(3*2^n)
# Space Complexity - O(n)
def bruteforce(cost):
    if len(cost)==0:
        return 0
    case1 = helper(cost,0,0,0)
    case2 = helper(cost,0,1,0)
    case3 = helper(cost,0,2,0)
    return min(case1,min(case2,case3))

def helper(cost,row,color,amount):
    #base
    if row>=len(cost):
        return amount
    #logic
    if color==0:
        return min(helper(cost,row+1,1,amount+cost[row][0]),helper(cost,row+1,2,amount+cost[row][0]))
    elif color==1:
        return min(helper(cost,row+1,0,amount+cost[row][1]),helper(cost,row+1,2,amount+cost[row][1]))
    else:
        return min(helper(cost,row+1,0,amount+cost[row][2]),helper(cost,row+1,1,amount+cost[row][2]))

cost = [[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]
print(bruteforce(cost))'''
    
