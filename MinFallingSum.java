/**
 * Time complexity: O(n*n) : since the matrix is n*n
 * Space complexity: O(n) + O(n) = O(n): 1D DP array and 1D temp array to record each row
 * Ran on leetcode?: Yes
 * Issues faced: None
 *
 * Approach:
 * - Greedy fails here if one of the row results in non-min value, which is possible given any test case
 * - There are repeating sub-problems, so can use DP to compute min at each row based on the rules
 */
public class MinFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;

        // use 1D dp array
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            // use temp to record each array
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    temp[j] = matrix[i][j] + Math.min(dp[j], dp[j + 1]);
                } else if (j == n - 1) {
                    temp[j] = matrix[i][j] + Math.min(dp[j], dp[j - 1]);
                } else {
                    temp[j] = matrix[i][j] + Math.min(dp[j], Math.min(dp[j - 1], dp[j + 1]));
                }
            }
            dp = temp;
        }

        int min = dp[0];
        for (int j = 1; j < n; j++) {
            min = Math.min(min, dp[j]);
        }

        return min;
    }

    public static void main(String[] args) {
        MinFallingSum obj = new MinFallingSum();
        int[][] arr = {
                {1,2,3,0},
                {5,1,2,1},
                {3,4,1,2},
                {6,7,9,1}
        };
        int minFallingPathSum = obj.minFallingPathSum(arr);
        System.out.println("Result: " + minFallingPathSum);
        assert (minFallingPathSum == 3);
    }
}
