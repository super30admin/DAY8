class Solution2{
    public int minCost(int[][] costs){
        int n = costs.length;
        int dp[][] = new int[n][3];
        int varR = costs[n-1][0];
        int varB = costs[n-1][1];
        int varG = costs[n-1][2];
        for(int i = n - 2; i >= 0; i--){
            int tempR = varR;
            varR = costs[i][0] + Math.min(varB, varG);
            int tempB = varB;
            varB = costs[i][1] + Math.min(tempR, varG);
            varG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(varR, Math.min(varB, varG));
    }

    public static void main(String args[]){
        Solution2 obj = new Solution2();
        // test case 1
        int[][] costs = {{17,2,17}, {16,16,5},{14,3,19}};
        System.out.println(obj.minCost(costs));
    }
}