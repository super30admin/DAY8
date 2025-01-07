class solution:
    def paintHouse(costs):
        # TC: O(n)
        # SC: O(1)
        if len(costs) == 0 or costs is None:
            return 0
        n = len(costs) # no of rows
        for i in range(n-2,-1,-1):
            costs[i][0] += min(costs[i+1][1],costs[i+1][2])
            costs[i][1] += min(costs[i+1][0],costs[i+1][2])
            costs[i][2] += min(costs[i+1][0],costs[i+1][1])
        return min(costs[0])
    costs=[[17,2,17],[16,16,5],[14,3,9]]
    print(paintHouse(costs))
    
