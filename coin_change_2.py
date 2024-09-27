#Time Complexity - O(mn) (length of the number of coins * amount)
#space complexity - O(mn)
#COmpiled successfully on leetcode - Yes
#Faced any issues - None

#Description:
#As the below problem is having common sub-problems we would try to solve this in dynamic programming.In here we take base cases as 0 if i#==0 and j==0 and 1 for i=0 and 1<j<amount.we solve the problem by filling the matrix by choosing  coin and not choosing.In the manner the #value at [len(coins)][amount] gives the number of combinations to give that amount.



class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        out=[[None for i in range(amount+1)] for j in range(len(coins)+1)]
        for i in range(len(coins)+1):
            for j in range(amount+1):
                if i==0:
                    if j==0:
                        out[i][j]=1
                    else:
                        out[i][j]=0
                else:
                    if coins[i-1]>j:
                        out[i][j]=out[i-1][j]
                    else:
                        out[i][j]=out[i-1][j]+out[i][j-coins[i-1]]
        return out[len(coins)][amount]
                