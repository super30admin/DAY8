"""
Time Complexity: 0((coins*amount))
Space Complexity: 0((coins*amount)
Approach: Memorization 2D/ Tabular
"""
class Solution:

    def change(self, amount: int, coins: List[int]) -> int:

        rows = len(coins) + 1
        cols = amount + 1

        # initialize 2D matrix
        memorization2D = [[0 for c in range(0,cols)] for r in range(0,rows)]

        # set col 0-index as 1
        for r in range(0,rows):
            memorization2D[r][0] = 1
        
        # fill memorization2D
        for r in range(1,rows):
            denomination = coins[r-1]

            for c in range(1,cols):

                if denomination > c:
                    # copy from above
                    memorization2D[r][c] = memorization2D[r-1][c]

                else:
                    above = memorization2D[r-1][c]       
                    behind = memorization2D[r][c-denomination]
                    memorization2D[r][c] = above + behind
            
            # end of cols iteration
        # end of row iteration


        # for r in range(0,rows):
        #     print(memorization2D[r])


        return memorization2D[-1][-1]