// Overall Time Complexity : O(n) . The n is number of houses in the matrix.
// Overall Space Complexity : O(1) . The space complexity is the size of the matrix.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// This solution calculates the minimum cost to paint houses such that no two adjacent houses have the same color.  
// It iterates from the last house to the first, updating the minimum cost dynamically using only three variables.  
// The approach runs in O(n) time and uses O(1) space, making it efficient.  


class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int varR = costs[n-1][0];
        int varB = costs[n-1][1];
        int varG = costs[n-1][2];

        for(int i = n-2; i>=0; i--){
            int tempR= varR;
            varR = costs[i][0]+Math.min(varB,varG);
            int tempB= varB;
            varB = costs[i][1]+Math.min(tempR,varG);
            varG = costs[i][2]+Math.min(tempR,tempB);

        }
        return Math.min(varR,Math.min(varB,varG));

       
    
}}