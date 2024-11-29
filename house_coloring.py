# // Time Complexity :O(n*m),n is the number of houses and m is the number of colours
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :no,premium account
# // Any problem you faced while coding this :not sure how to implement the logic to keep track of the path


# // Your code here along with comments explaining your approach



cost_arr=[[1,5,7],[5,8,4],[3,2,9],[1,2,4]]

for i in range(len(cost_arr)-2,-1,-1):
    
    cost_arr[i][0]=cost_arr[i][0]+min(cost_arr[i+1][1],cost_arr[i+1][2])
    
    cost_arr[i][1]=cost_arr[i][1]+min(cost_arr[i+1][0],cost_arr[i+1][2])
    
    cost_arr[i][2]=cost_arr[i][2]+min(cost_arr[i+1][1],cost_arr[i+1][0])
    
print(min(cost_arr[0][0],cost_arr[0][1],cost_arr[0][2]))