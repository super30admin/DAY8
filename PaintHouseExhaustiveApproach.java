/*
Time Complexity: Time Limit exceeded due to exponential Time complexity O(m*2^(n)) where n is depth of the tree which is
                 total no of houses and m is the total no of colors

Space Complexity: O(n) as those many recursive calls will happen

Did this code successfully run on Leetcode: No as time limit exceeded.

For the "Paint House" problem, a greedy approach won’t yield the optimal solution because each choice depends on
future choices in a way that cannot be decided locally. In other words, choosing the cheapest color for the current
house without considering future costs can lead to suboptimal results.

Why Greedy Doesn't Work
For each house, selecting the cheapest available color may work for that house, but it may force a more expensive
choice for the next house. This problem has a "global optimality" requirement because the cost of painting each
house affects the total minimum cost only when all subsequent choices are also considered.
 */

//SOLUTION 1
public class PaintHouseExhaustiveApproach
{
    public int minCost(int[][] costs) {

        int colorR =  helper(costs, 0, 0, 0);
        int colorB =  helper(costs, 0, 1, 0);
        int colorG =  helper(costs, 0, 2, 0);

        return Math.min(colorR, Math.min(colorB, colorG));
    }

    private int helper(int[][] costs, int i, int color, int totalCost)
    {
        /*
        i is the index to check which house we are on, on 0th or 1st or 2nd
        color to check which color we have choosen for current house
        */

        //base case
        if(i == costs.length) return totalCost;

        //logic
        /*
        If for the current house, we have choosen the color = 0, for the next house we can
        either choose color 1 or color 2
        */
        if(color == 0)
        {
            return Math.min(helper(costs, i+1, 1, totalCost + costs[i][color]),
                    helper(costs, i+1, 2, totalCost + costs[i][color]));
        }
        else if(color == 1)
        {
            return Math.min(helper(costs, i+1, 0, totalCost + costs[i][color]),
                    helper(costs, i+1, 2, totalCost + costs[i][color]));
        }
        else if(color == 2)
        {
            return Math.min(helper(costs, i+1, 0, totalCost + costs[i][color]),
                    helper(costs, i+1, 1, totalCost + costs[i][color]));
        }

        return 0; //We will not be reaching this statement
    }
}

/*
SOLUTION 2

If there are many colors, we can not keep on writing "if" statements for every color

class Solution {
    public int minCost(int[][] costs) {

       int colorR =  helper(costs, 0, 0, 0);
       int colorB =  helper(costs, 0, 1, 0);
       int colorG =  helper(costs, 0, 2, 0);

       return Math.min(colorR, Math.min(colorB, colorG));
    }

    private int helper(int[][] costs, int i, int color, int totalCost)
    {

        i is the index to check which house we are on, on 0th or 1st or 2nd
        color to check which color we have choosen for current house


        //base case
        if(i == costs.length) return totalCost;

        //logic

        int min = Integer.MAX_VALUE;
        for(int c=0; c<costs[0].length; c++)
        {
            if (c != color)
            {
            min = Math.min(min, helper(costs, i+1, c, totalCost + costs[i][color]));
            }
        }

        return min;
    }
}

 */