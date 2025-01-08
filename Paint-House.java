// Problem : https://leetcode.com/problems/paint-house/
// It is a leetcode premium problem:

// Time Complexity :Exponential
// Space Complexity : Not Sure
// Did this code successfully run on Leetcode :Not tried
// Any problem you faced while coding this :

class solution{
    public int minCost(int[][] costs){
        //Base Condition Check
        if(costs==null || costs.length==0){
            return 0;
        }
        //Calling recursively for each row seperately
        int costRed = recurse(costs,0,0,0);
        int costBlue = recurse(costs,0,1,0);
        int costGreen = recurse(costs,0,2,0);
        //returning minimum of all 3
        return(Math.min(costRed,Math.min(costBlue,costGreen)));
    }
}
private int recurse(int[][] costs,int row,int col,int costIncurred){

    if(row==costs.length){
        return costIncurred;      
    }
    if(col==0){
       return(Math.min(recurse(costs,row+1,1,costIncurred+cost[row][col]),recurse(costs,row+1, 2,costIncurred+cost[row][col])))
    }
    if(col==1){
       return(Math.min(recurse(costs,row+1,0,costIncurred+cost[row][col]),recurse(costs,row+1, 2,costIncurred+cost[row][col])))
    }if(col==2){
       return(Math.min(recurse(costs,row+1,0,costIncurred+cost[row][col]),recurse(costs,row+1, 1,costIncurred+cost[row][col])))
    }

}


Approach 2:
// Time Complexity : O(n)
// Space Complexity :0(1) as we are mutating in same array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class solution{
    public int minCost(int[][] costs){
        //Base Condition check
        if(costs==null || costs.length==0){
            return 0;
        }
        //Length of an costs array
        int n=costs.length;
        for(int i=n-2;i>=0;i--){
            costs[i][0]=costs[i][0]+Math.Min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]=costs[i][1]+Math.Min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]=costs[i][2]+Math.Min(costs[i+1][0],costs[i+1][1]);
        }
        //We will be returning the minimum of costs[0][0],costs[0][1],costs[0][2]
        return Math.Min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}