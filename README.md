# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)

In this solution we are going from last house to the first one. The last row we will store the origial costs of red blue and green paints. Then, when we will go to the above row we will check the minimum value from below row with other two colors except the current one and add it to the current cost of the color. For example we are in the second last row red color column and checking the cost we will check the minimum cost between blue and green of the next row and add it to the cost of red color. If we go like this till the top row then in the top row we will get the costs of all the paths and we will choose the minimum cost.



## Problem2 (https://leetcode.com/problems/coin-change-2/)

Here we are going to use same approach we used in Coin Change 1 but here instead of amount we will store number of ways to achieve given amount. In this first we will initialize all the elements in the 0th row matrix of the dp to 1. Then we will use a nested for loop and for each element if the current amount is less than the coin which we are using we will assign i-1 row number as it is as there is no way to make that amount with lesser number of coin. In the else block we will get the existing number of ways from i-1 row and add it with the number of ways which we could use from the same row and amount-current coin index. So, basically we are checking if we subtract current coin from current amount then the remaining amount can be achieved using same coin. At the end we will return the last element of dp which will have total number of ways.