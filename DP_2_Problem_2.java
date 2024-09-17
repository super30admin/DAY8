
//Time Complexity : O(m*n)
//Space Complexity: O(m*n)
//Run successfully on leetcode
//Problem : analyzing the pattern

public class DP_2_Problem_2 {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return 0;
        int[][] matrix = new int[coins.length+1][amount+1];
        for(int i=0;i<matrix.length;i++)
        {
            matrix[i][0]=1;
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    matrix[i][j] = matrix[i-1][j];
                }
                else
                {
                    matrix[i][j]= matrix[i-1][j] + matrix[i][j-coins[i-1]];
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];

    }
}
