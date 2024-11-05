public class Problem1 {
    public int minCost(int[][] costs) {
       /* int minCost = Integer.MAX_VALUE;
        for(int i=0;i<costs[0].length;i++){
           minCost = Math.min(recurHelper(costs,i,0),minCost);
        }

        return minCost;
        */
        return paintHuseDP(costs);
    }

    public int recurHelper(int[][] costs,int color,int idx ){

        //base condition
        if(idx == costs.length){
            return 0;
        }

        int totalCost = costs[idx][color];

        if(color == 0){
            totalCost+=Math.min(recurHelper(costs,1,idx+1),recurHelper(costs,2,idx+1));
        }else if(color == 1){
            totalCost+=Math.min(recurHelper(costs,0,idx+1),recurHelper(costs,2,idx+1));
        }else{
            totalCost+=Math.min(recurHelper(costs,0,idx+1),recurHelper(costs,1,idx+1));
        }
        return totalCost;
    }

    //TC:O(M*N)
//SC : O(M*N)
    public int paintHuseDP(int[][] costs ){
        int n = costs[0].length;
        int m = costs.length;
        int [][] dp = new int [m][n] ;

        //populating the last row in DP
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i=m-2 ;i>=0;i--){
            //chose color 0

            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);

            //chose color 1
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);

            //chose color 2
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
        }


        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }

}
