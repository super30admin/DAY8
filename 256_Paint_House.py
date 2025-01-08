#time: O(no.of house*3)
#space: O(no.of house*3)
#tested on leetcode: no, just this testcase

def minCost(costs):
    arr= list(costs)
    if(len(arr) == 0):
        return 0
    if (len(arr) == 1):
        return min(arr[0][0], min(arr[0][1],arr[0][2]))
    # print(len(arr))
    for r in range(1,len(arr)):
        for c in range(len(arr[0])):
            if(c==0):
                arr[r][0]= arr[r][0] + min(arr[r-1][1], arr[r-1][2])
            elif(c==1):
                arr[r][1]= arr[r][1] + min(arr[r-1][0], arr[r-1][2])
            elif(c==2):
                arr[r][2]= arr[r][2] + min(arr[r-1][0], arr[r-1][1])

  
    return min(arr[len(arr)-1][0], min(arr[len(arr)-1][1],arr[len(arr)-1][2])) 

# Driver Code
if __name__ == "__main__":
    costs = [
        [17, 2, 17],
        [16, 16, 5],
        [14, 3, 19]
    ]  # Example input

    print("Minimum cost to paint all houses:", minCost(costs))
