// time compllexity - O(n) where n = number of houses
// space complexity - O(1) as the solution done using 3 variables
public class Solution
{
    public int MinCost(int[][] costs)
    {
        if (costs == null || costs.Length == 0)
        {
            return 0;
        }
        int m = costs.Length;
        int valR = costs[m - 1][0];
        int valB = costs[m - 1][1];
        int valG = costs[m - 1][2];

        for (int i = m - 2; i >= 0; i--)
        {
            int tempR = valR;
            valR = costs[i][0] + Math.Min(valB, valG);
            int tempB = valB;
            valB = costs[i][1] + Math.Min(tempR, valG);
            valG = costs[i][2] + Math.Min(tempR, tempB);
        }
        return Math.Min(valR, Math.Min(valB, valG));
    }
}