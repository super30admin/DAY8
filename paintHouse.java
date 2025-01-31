// Problem1(https://leetcode.com/problems/paint-house/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here dynamic programming is used. For red, the minimun value of the the succeding rows blue and green color is added and in the same way for 
 * blue and green also. From the calculated values, the minimum among final red, blue and green is taken as the minimum cost. 
 */

class solution{
    public int paint(int [][]costs){
        int n = costs.length;
        if(costs.length == 0){
            return 0;
        }
        int varR = costs[n-1][0];
        int varB = costs[n-1][1];
        int varG = costs[n-1][2];
        for(int i = n-2; i>=0;i--){
            int tempR = varR;
            varR = costs[i][0] + Math.min(varR, varB);
            int tempB = varB;
            varB = costs[i][1]+Math.min(tempR, varG);
            varG = costs[i][2]+Math.min(tempR, tempB);
    }
    return Math.min(varR, Math.min(varB, varG));
    }
}
