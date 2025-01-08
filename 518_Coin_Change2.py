#Time: O(amount* coins)
#Space: O(amount* coins)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        arr = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]

        for r in range(len(coins) + 1):
            arr[r][0]=1

        for r in range(1,len(coins) + 1):
            for c in range (1, amount + 1):
                if ( c < coins[r-1]):
                    arr[r][c] = arr[r-1][c]
                else:
                    arr[r][c]= arr[r-1][c] + arr[r][c - coins[r-1]]
        return arr[len(coins)][amount]

        
