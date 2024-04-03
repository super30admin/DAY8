// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
// (https://leetcode.com/problems/paint-house/)

import java.util.Arrays;
// import javafx.util.Pair;

/**
 * Find the min. cost => think greedily i.e. paint the house with a color
 * associated to the min cost for this house
 * 
 * eg: [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
 * row 0 => min == color 1 == 2
 * row 1 => min == color 2 == 5
 * row 2 => min == color 1 == 3
 * 
 * min cost = 2 + 5 + 3 = 10
 * hence, greedy passes.
 * 
 * eg: [[17, 2, 17], [16, 5, 16], [14, 3, 19]]
 * row 0 => min == color 1 == 2
 * row 1 => min == color 1 == 5 => but we can't pick this color as it has
 * already been used by the previous (or adjacent) house
 * we should choose any other color not the smallest as per the painting
 * constraint
 * 
 * hence, greedy fails.
 * 
 * 
 * If Greedy fails ==> try all possible combos == RECURSION (top-down)
 * TRY painting each house with all the colors (except the previously painted
 * house's color) --> go to the next house
 * 
 * Draw the recursive tree
 * 
 * such that at each step the problem boils down to find min cost to paint a
 * house, given previous house's color (as no 2 adjacent houses should have the
 * same color) == RECURRENCE RELATION
 * 
 * for each house, we have 3 colors to pick from (except the previous color) ==
 * LOGIC
 * 
 * we continue, till all houses are painted == BASE CASE
 * 
 * hence, TC: exponential
 * SC: stack space i.e. # of houses == O(n)
 * 
 * 
 * 
 * WE find that the recursive tree has overlapping subproblems => DP
 * (MEMOIZATION)
 * 
 * we've 2 changing params, house (to be painted) and the prevColor (previously
 * painted house's color)
 * 
 * hence, use a 2D dp
 * # of rows == param 1 == # of houses
 * # of columns == param 2 == # of colors
 * NOTE: for the 1st house to be painted, we've 3 possible ways, hence prev
 * color = 3
 * therefore, dp[n][4]
 * 
 * TC: O(n * 4)
 * SC: O(n) + O(n * 4) == stack + dp array
 * 
 * 
 * Ovecome the stack space, by avoiding recursion, i.e., TABULATION (bottom-up)
 * 
 * don't think, just replicate the recurrence
 * move from the base case (of recursion) to the start call
 * 
 * return the start call of recursion as ans == dp[n-1][3]
 * 
 * TC: O(n * 4)
 * SC: O(n * 4)
 * 
 * 
 * Space Optimization == as at each step we're interested only in the previous
 * house, the other computed houses don't matter, so why to store ?
 * TC: O(n * 4)
 * SC: O(1)
 */
public class PaintHouse_LC_256 {

    /**
     * Recursion
     * TC: Exponential
     * SC: O(n)
     */
    public int minCost_recursion(int[][] costs) {
        int n = costs.length;
        return minCost_recursion(costs, n - 1, 3);
    }

    private int minCost_recursion(int[][] costs, int house, int prevColor) {
        int minCost = Integer.MAX_VALUE;
        if (house == 0) {
            for (int color = 0; color < 3; color++) {
                if (color != prevColor) {
                    minCost = Math.min(minCost, costs[house][color]);
                }
            }
            return minCost;
        }

        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                int cost = minCost_recursion(costs, house - 1, color);
                minCost = Math.min(minCost, cost + costs[house][color]);
            }
        }

        return minCost;
    }

    /**
     * Memoization
     * TC: O(n * 4)
     * SC: O(4 * n) + O(n)
     */
    public int minCost_memoize(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][4];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return minCost_memoize(costs, n - 1, 3, dp);
    }

    private int minCost_memoize(int[][] costs, int house, int prevColor, int[][] dp) {
        int minCost = Integer.MAX_VALUE;
        if (house == 0) {
            for (int color = 0; color < 3; color++) {
                if (color != prevColor) {
                    minCost = Math.min(minCost, costs[house][color]);
                }
            }
            return dp[0][prevColor] = minCost;
        }

        if (dp[house][prevColor] != -1) {
            return dp[house][prevColor];
        }

        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                int cost = minCost_memoize(costs, house - 1, color, dp);
                minCost = Math.min(minCost, cost + costs[house][color]);
            }
        }

        return dp[house][prevColor] = minCost;
    }

    /**
     * Tabulation
     * TC: O(n * 4)
     * SC: O(4 * n)
     */
    public int minCost_tabulation(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][4];

        // base case == house 0
        int minCost;
        for (int prevColor = 0; prevColor < 4; prevColor++) {
            minCost = Integer.MAX_VALUE;
            for (int color = 0; color < 3; color++) {
                if (color != prevColor) {
                    minCost = Math.min(minCost, costs[0][color]);
                }
            }
            dp[0][prevColor] = minCost;
        }

        for (int house = 1; house < n; house++) {
            for (int prevColor = 0; prevColor < 4; prevColor++) {
                minCost = Integer.MAX_VALUE;

                for (int color = 0; color < 3; color++) {
                    if (color != prevColor) {
                        int cost = dp[house - 1][color];
                        minCost = Math.min(minCost, cost + costs[house][color]);
                    }
                }

                dp[house][prevColor] = minCost;
            }
        }
        return dp[n - 1][3];
    }

    /**
     * Space Optimization == as at each step we're interested only in the previous
     * house, the other computed houses don't matter, so why to store ?
     * TC: O(n * 4)
     * SC: O(1)
     */
    public int minCost_optimal(int[][] costs) {
        int n = costs.length;
        int[] prev = new int[4];

        int minCost;
        for (int prevColor = 0; prevColor < 4; prevColor++) {
            minCost = Integer.MAX_VALUE;
            for (int color = 0; color < 3; color++) {
                if (color != prevColor) {
                    minCost = Math.min(minCost, costs[0][color]);
                }
            }
            prev[prevColor] = minCost;
        }

        for (int house = 1; house < n; house++) {
            int[] curr = new int[4];
            for (int prevColor = 0; prevColor < 4; prevColor++) {
                minCost = Integer.MAX_VALUE;

                for (int color = 0; color < 3; color++) {
                    if (color != prevColor) {
                        int cost = prev[color];
                        minCost = Math.min(minCost, cost + costs[house][color]);
                    }
                }

                curr[prevColor] = minCost;
            }
            prev = curr;
        }
        return prev[3];
    }

    class Pair {
        int cost;
        int color;

        Pair(int cost, int color) {
            this.cost = cost;
            this.color = color;
        }
    }

    public int[] minCost_tabulation_path(int[][] costs) {
        int n = costs.length;
        Pair[][] dp = new Pair[n][4];
        int[] coloredHouses = new int[n];

        // base case == house 0
        int minCost, minColor;
        for (int prevColor = 0; prevColor < 4; prevColor++) {
            minCost = Integer.MAX_VALUE;
            for (int color = 0; color < 3; color++) {
                if (color != prevColor) {
                    minCost = Math.min(minCost, costs[0][color]);
                }
            }
            dp[0][prevColor] = new Pair(minCost, -1);
        }

        for (int house = 1; house < n; house++) {
            for (int prevColor = 0; prevColor < 4; prevColor++) {
                minCost = Integer.MAX_VALUE;

                minColor = 3;
                for (int color = 0; color < 3; color++) {
                    if (color != prevColor) {
                        int cost = dp[house - 1][color].cost + costs[house][color];
                        if (minCost > cost) {
                            minColor = color;
                            minCost = cost;
                        }
                    }
                }

                dp[house][prevColor] = new Pair(minCost, minColor);
            }
        }

        minCost = dp[n - 1][3].cost;
        coloredHouses[n - 1] = dp[n - 1][3].color;
        minCost -= costs[n - 1][coloredHouses[n - 1]];
        // find path
        for (int house = n - 2, color = 0; house >= 0; house--) {
            for (color = 0; color < 3; color++) {
                if (dp[house][color].cost == minCost) {
                    coloredHouses[house] = dp[house][color].color;
                    break;
                }
            }
            minCost -= costs[house][color];
        }
        return coloredHouses;
    }

    /**
     * Tabulation
     * TC: O(n * 4)
     * SC: O(4 * n)
     */
    public int minCost_tabulation_2(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        // base case == house 0
        int minCost;
        for (int color = 0; color < 3; color++) {
            dp[0][color] = costs[0][color];
        }

        for (int house = 1; house < n; house++) {
            for (int color = 0, prevColor = 0; color < 3; color++) {
                minCost = Integer.MAX_VALUE;

                for (prevColor = 0; prevColor < 3; prevColor++) {
                    if (color != prevColor) {
                        int cost = dp[house - 1][prevColor];
                        minCost = Math.min(minCost, cost);
                    }
                }

                dp[house][color] = minCost + costs[house][color];
            }
        }

        minCost = Integer.MAX_VALUE;
        for (int color = 0; color < 3; color++) {
            minCost = Math.min(minCost, dp[n - 1][color]);
        }
        return minCost;
    }

    /**
     * Store the previous color at each step and backtrack.
     * 
     * @param costs
     * @return
     */
    public int[] minCost_tabulation_2_path(int[][] costs) {
        int n = costs.length;
        Pair[][] dp = new Pair[n][3];
        int[] coloredHouses = new int[n];

        // base case == house 0
        int minCost, minColor;
        for (int color = 0; color < 3; color++) {
            dp[0][color] = new Pair(costs[0][color], -1);
        }

        for (int house = 1; house < n; house++) {
            for (int color = 0, prevColor = 0; color < 3; color++) {
                minCost = Integer.MAX_VALUE;
                minColor = 3;

                for (prevColor = 0; prevColor < 3; prevColor++) {
                    if (color != prevColor) {
                        int cost = dp[house - 1][prevColor].cost;
                        minCost = Math.min(minCost, cost);
                        if (minCost > cost) {
                            minColor = prevColor;
                            minCost = cost;
                        }
                    }
                }

                dp[house][color] = new Pair(minCost + costs[house][color], minColor);
            }
        }

        minCost = Integer.MAX_VALUE;
        minColor = 3;
        for (int color = 0; color < 3; color++) {
            if (minCost > dp[n - 1][color].cost) {
                minCost = dp[n - 1][color].cost;
                minColor = color;
            }
        }
        coloredHouses[n - 1] = minColor;

        // find path
        for (int house = n - 2; house >= 0; house--) {
            coloredHouses[house] = dp[house + 1][minColor].color;
            minColor = dp[house][coloredHouses[house]].color;
        }
        return coloredHouses;
    }

}