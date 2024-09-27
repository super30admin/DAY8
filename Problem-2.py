#Time Complexity: O(n*m) n-coin m-amount
#Space Complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        table = [0] * (amount + 1) 
        print(table)
        table[0]=1 #there is 1 way to make 0 amount 
        print(table)
        
        for i in coins: #T(n) n-coint
            for j in range(1,amount+1): #T(m) m-amount
                if i<=j:
                    table[j]=table[j]+table[j-i]
        
        return table[amount]
                