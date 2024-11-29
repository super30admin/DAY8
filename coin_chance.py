# // Time Complexity :O(n*m),n is the number of coins and m is amount
# // Space Complexity :O(n*m)
# // Did this code successfully run on Leetcode :no,premium account
# // Any problem you faced while coding this :not sure how to implement the logic to keep track of the path


# // Your code here along with comments explaining your approach






class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        li=[]
        li.append([1])
        for i in range(amount):
            print(i)
            li[0].append(0)
        for i in range(1,len(coins)+1):
            li.append([])
            for j in range(amount+1):
                
                if j<coins[i-1]:
                    li[i].append(li[i-1][j])
                else:
                    li[i].append(li[i-1][j]+li[i][j-coins[i-1]])
        return li[len(coins)][amount]
                
        