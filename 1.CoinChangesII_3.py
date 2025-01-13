"""
Time Complexity: 0((coins*amount))
Space Complexity: 0((coins*amount)
Approach: Memorization 1D/ Tabular
"""
class Solution:

    def change(self, amount: int, coins: List[int]) -> int:

        rows = len(coins) + 1
        cols = amount + 1

        # initialize 1D matrix
        memorization1D = [0 for c in range(0,cols)]

        # set col 0-index as 1
        memorization1D[0] = 1
        
        # fill memorization2D
        for r in range(1,rows):
            denomination = coins[r-1]

            for c in range(1,cols):

                if denomination > c:
                    # copy from above
                    # memorization2D[r][c] = memorization2D[r-1][c]
                    continue

                else:
                    # above = memorization2D[r-1][c]       
                    # behind = memorization2D[r][c-denomination]
                    # memorization2D[r][c] = above + behind

                    # above -- same (c) index value
                    behind = memorization1D[c-denomination]
                    memorization1D[c] = memorization1D[c] + behind
            
            # end of cols iteration
        # end of row iteration


        # for r in range(0,rows):
        #     print(memorization2D[r])

        print(memorization1D)

        return memorization1D[-1]
