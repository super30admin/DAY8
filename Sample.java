/**********************PROBLEM-1*************************/
// Time Complexity : 2^n exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO (Time limit exceeded)
// Any problem you faced while coding this : NO

//recursive approach
class Solution {
    public int minCost(int[][] costs) {
        //
        if(costs==null || costs.length==0){
            return 0;
        }
        int costRed=recurse(costs,0,0,0);
        int costBlue=recurse(costs,1,0,0);
        int costGreen=recurse(costs,2,0,0);
        return Math.min(costRed,Math.min(costBlue,costGreen));
    }

    private int recurse(int[][] costs,int column,int house,int amount){
        //base
        if(house==costs.length){
            return amount;
        }

        //logic
        if(column==0){
            return Math.min(recurse(costs,1,house+1,amount+costs[house][0]),
                    recurse(costs,2,house+1,amount+costs[house][0]));
        }else if(column==1){
            return Math.min(recurse(costs,0,house+1,amount+costs[house][1]),
                    recurse(costs,2,house+1,amount+costs[house][1]));
        }else{
            return Math.min(recurse(costs,0,house+1,amount+costs[house][2]),
                    recurse(costs,1,house+1,amount+costs[house][2]));
        }

    }

}

// Time Complexity : O(N) N= no of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//storing the min from bottom to top and comparing the min in first row to get the result
class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0){
            return 0;
        }
        int n=costs.length-1;
        for(int i=n-1;i>=0;i--){
            costs[i][0]=costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]=costs[i][1]+Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]=costs[i][2]+Math.min(costs[i+1][0],costs[i+1][1]);
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}

/*********************** PROBLEM-2 *************************/
// Time Complexity : 2^n exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO (Time limit exceeded)
// Any problem you faced while coding this : NO


//recursive function approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0){
            return 0;
        }
        int combos=recurse(coins,amount,0,0);
        return combos;
    }

    private int recurse(int[] coins,int amount,int index,int combo){
        //base
        if(index==coins.length || amount<0){
            return 0;
        }
        if(amount==0){
            return combo+1;
        }

        //logic
        int case0=recurse(coins,amount,index+1,combo);
        int case1=recurse(coins,amount-coins[index],index,combo);
        return case0+case1;
    }
}

// Time Complexity : 0(m*n) m=no of Coins, n=amount
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//store the different combinations in a matrix and optimize the matrix filling using previously
//stored values.
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }

            }
        }
        return dp[coins.length][amount];
    }
}