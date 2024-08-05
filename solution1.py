# Time: O(n)
# Space: O(n)

def paintHouses(costs):
    print(helper1(costs))

def helper2(costs):
    houses = len(costs)
    red, blue, green = costs[houses - 1][0], costs[houses - 1][1], costs[houses - 1][2]
    for i in range(houses - 2, -1, -1):
        tempR = red
        red = costs[i][0] + min(blue, green)
        tempB = blue
        blue = costs[i][1] + min(tempR, green)
        green = costs[i][2] + min(tempR, tempB)

    return min(red, blue, green)


def helper1(costs):
    houses = len(costs)
    colors = len(costs[0])
    dp = [[0 for i in range(3)] for j in range(houses)]
    
    for j in range(3):
        dp[houses - 1][j] = costs[houses - 1][j]
    
    for i in range(houses-2, -1, -1):
        # consider 3 colors for now
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][1])
    return min(dp[0][0], dp[0][1], dp[0][2])

paintHouses([[17,2,7],[16,16,5],[14,13,19]])