# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
# Dynamic programming
# Bottom up approach where we populate the last row of the matrix by the color values.
# Add the colour value for every colour combination and update the above row.
# Get the minimum value from the first row which is the min cost to paint the house.
             

## Problem2 (https://leetcode.com/problems/coin-change-2/)
## Dynamic programming
# Edge case conditions when the coins array is empty or has no coins then we return 0.
# Create a 2D matrix where the rows represent the amount and the column represents the value of coins.
# We exhaustively search for each amount and coin value and store the iterations in the matrix
# The last row column will have the combinations in which the target amount can be calculated.
