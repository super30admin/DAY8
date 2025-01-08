public class Solution
{
    public int MinCost(int[][] costs)
    {
        if (costs == null || costs.Length == 0)
        {
            return -1;
        }

        int n = costs.Length;
        for (int i = n - 2; i >= 0; i--)
        {
            costs[i][0] += Math.Min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.Min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.Min(costs[i + 1][0], costs[i + 1][1]);
        }

        return Math.Min(costs[0][0], Math.Min(costs[0][1], costs[0][2]));
    }
}