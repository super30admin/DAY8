//518. House coloring
// Given a row of n houses, each house can be coloured with any of the three colours: 
// let these be red blue or green. the cost for painting a particular house with a particular colour 
// is going to be different. you have to colour the house in such a way that no two adjacent houses will 
// have the same colour. the cost for painting  a house with any colour is represented by a n X 3 cost matrix 
// where cost for painting house 0 with colour red is cost[0][0] and cost for painting house 4 with green colour 
// is cost[4][2] and so on.....calculate the minimum cost to paint all houses. try to optimize it for space !!

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :no I do not have premium
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// exhaustive approach  TC- 3.2^n (because three houses and each node produces 2 babies) SC- O(n)-----------------

// public class HouseColouring {

//     public int minCost(int[][] costs){

//          int costR = helper(costs, 0, 0, 0);
//          int costB = helper(costs, 0, 1, 0);
//          int costG = helper(costs, 0, 2, 0);

//          return Math.min(costR, Math.min(costB, costG));
//     }

//     private int helper(int[][] costs, int i, int color, int totalCost){

//         if(i >= costs.length) return totalCost;

//         if(color == 0){
//             return Math.min(helper(costs, i+1, 1, totalCost + costs[i][0]), helper(costs, i+1, 2, totalCost + costs[i][0]));
//             // so we have have matrix rows as house and coloumns as colors. stating from i as house 0, in this case color first 0, 
//             //so if have color 0 in this case tree will grow picking color for next house that is i+1, and other colors not 0 that are 1 and 2.
//             // and total cost as previous cost plus current cost that is present house and color.
//         }else if(color ==1){
//             return Math.min(helper(costs, i+1, 0, totalCost + costs[i][1]), helper(costs, i+1, 2, totalCost + costs[i][1]));
//             //this case starting from second color that is 1
//         }else if(color == 2){
//             return Math.min(helper(costs, i+1, 0, totalCost + costs[i][2]), helper(costs, i+1, 1, totalCost + costs[i][2]));
//         }
//         //can be more than 3 colors

//         return 0;

//     }  

//     public static void main (String[] args)

// {

//     HouseColouring HC = new HouseColouring();

//  int[][] arr = new int[][]{{2,3,1},{3,5,3},{7,100,101},{3,400,500}};



//    System.out.println(HC.minCost(arr));

// }
// }

//----------------DP approach---------------------------------------------------------------
//TC - O(m) SC-mn

public class HouseColouring {

    public int minCost(int[][] costs){
      
        int m = costs.length;
        int n = costs[0].length;


        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++){
            dp[m-1][i] = costs[m-1][i];
              //in dp matrix from last row we assigned last row of costs
        }

        for(int i = m-2; i>=0; i--){
            dp[i][0] = costs[i][0]  + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1]  + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2]  + Math.min(dp[i+1][0], dp[i+1][1]);
            //here we start dp from second last row at each column we keep value addition of current value 
            //and min from next row alternate columns this way we are keeping the min total cost from each sub tree from bottom up approach


        } 

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));

    }



    public static void main (String[] args)

{

    HouseColouring HC = new HouseColouring();

 int[][] arr = new int[][]{{2,3,1},{3,5,3},{7,100,101},{3,400,500}};



   System.out.println(HC.minCost(arr));

}
}

