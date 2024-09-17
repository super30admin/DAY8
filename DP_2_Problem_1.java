//Brute force
//Time Complexity : O(2^n * 3))
//Space Complexity : Just the stack space O(1)
// Have not bought leetcode premium yet
// Problems :  No problem

//Optimized DP
//Time Complexity : O(n)
//Space Complexity: O(m*n)
//Run successfully on leetcode
//Problem : No problem

public class DP_2_Problem_1 {
    public static int minCost(int[][] costs) {
        if(costs==null || costs.length==0)return 0;

        int case1 = helper(costs,0,0,0);
        int case2 = helper(costs,0,1,0);
        int case3 = helper(costs,0,2,0);
        return Math.min(case1,Math.min(case2,case2));

    }
    private static int helper(int[][] costs,int row,int col,int sum)
    {
        if(row == costs.length) return sum;
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;

        if(col==0)
        {
            case1 = Math.min(
            helper(costs,row+1,1,sum + costs[row][col]),
            helper(costs,row+1,2,sum + costs[row][col]));
        }
        else if(col==1)
        {
            case2=Math.min(
            helper(costs,row+1,0,sum + costs[row][col]),
            helper(costs,row+1,2,sum + costs[row][col]));
        }
        else if(col==2)
        {
            case3 = Math.min(
            helper(costs,row+1,0,sum + costs[row][col]),
            helper(costs,row+1,1,sum + costs[row][col]));
        }

        return Math.min(case1,Math.min(case2,case3));
    }

    public static int minPaint(int[][] costs)
    {
        if(costs == null || costs.length == 0)return 0;
        int[][] dp = new int[costs.length][costs[0].length];
        dp[0] = costs[0];
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j] = costs[i][j] + Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
            }
        }
        return Math.min(dp[dp.length-1][0],Math.min(dp[dp.length-1][1],dp[dp.length-1][2]));
    }

    public static void main(String[] args) {
        int costs[][]= {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minPaint(costs));

    }

}
