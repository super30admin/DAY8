/*
Recursive approach -> Find all combinations TC - 3*2^n

DP tabulation -> create matrix with parameters as costs and color-> Get min
TC-> O(n*3), SC - O(n*3);

Reduce space by not using another matrix.
*/

class Solution {
    public int minCost(int[][] costs) {

        // int color0 = helper(costs, 0, 0, 0);
        // int color1 = helper(costs, 0, 1, 0);
        // int color2 = helper(costs, 0, 2, 0);
        // return Math.min(color0,Math.min(color1,color2));

        // DP tabulation approach
        int n = costs.length;
        int[][] mat = new int[n][3];

        for(int j =0;j<3;j++){
            mat[n-1][j] = costs[n-1][j];
        }

        for(int i =n-2;i>=0;i--){
            mat[i][0] = costs[i][0]+Math.min(mat[i+1][1],mat[i+1][2]) ;
            mat[i][1] = costs[i][1]+Math.min(mat[i+1][0],mat[i+1][2]) ;
            mat[i][2] = costs[i][2]+Math.min(mat[i+1][0],mat[i+1][1]) ;

        }
        return Math.min(mat[0][0],Math.min(mat[0][1],mat[0][2]));
    }
    // color is the column -> 0,1,2
    private int helper(int[][] costs, int i, int color, int totalCost){

        //base
        if(i==costs.length){
            return totalCost;
        }
        //logic
       // choose color 0,1 or 2 and find min of them
        if(color == 0){
            return Math.min(helper(costs, i+1, 1, totalCost+costs[i][0]),
                            helper(costs, i+1 ,2, totalCost+costs[i][0]));
        }  else if(color == 1){
            return Math.min(helper(costs, i+1 ,0, totalCost+costs[i][1]),
                            helper(costs, i+1 ,2, totalCost+costs[i][1]));
        } else if(color == 2){
            return Math.min(helper(costs, i+1, 0, totalCost+costs[i][2]),
                            helper(costs, i+1 ,1, totalCost+costs[i][2]));
        }
        return 2222;
    }
}