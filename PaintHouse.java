// Approach : Exhuast every possible case. For ecah case decide one color to paint for a house and calculate min cost.
// Time: colors * 2 ^(n) = O(2^n)
// Space: Recursive space
class Solution {
    public int minCost(int[][] costs) {

        int case1= helper(costs,0,0,0);
        int case2=helper(costs,0,0,1);
        int case3=helper(costs,0,0,2);

        return Math.min(case1,Math.min(case2,case3));
        
    }
    private int helper(int[][] costs , int min, int row, int lastColor){
        // Base case:
        if(row == costs.length) return min;

        // logic
        int case1 = Integer.MAX_VALUE;
        int case2= Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;

        // Red
        if(lastColor == 0){
            case1 = Math.min(helper(costs,min+costs[row][1],row+1,1),//blue
                    helper(costs,min+costs[row][2],row+1,2)//green
                    );
        }
        // blue
        if(lastColor == 1){
            case1 = Math.min(helper(costs,min+costs[row][0],row+1,0),//red
                    helper(costs,min+costs[row][2],row+1,2)//green
                    );
        }
        // green
        if(lastColor == 2){
            case1 = Math.min(helper(costs,min+costs[row][0],row+1,0),//red
                    helper(costs,min+costs[row][1],row+1,1)//blue
                    );
        }
        return Math.min(case1,Math.min(case2,case3));
    }
}

// Approach: Dynamic Programming without extra space
// Time: o(m*n)
// Space: O(1) // utilizing the costs array
class Solution {
    public int minCost(int[][] costs) {
        // Base case
        if(costs==null || costs.length==0) return 0;
        int n=costs.length;
        for(int i=1;i<n;i++){
            // case 1 - choose red
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            // case 2 - choose blue
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            // case 3 - choose green
            costs[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
        }
        return Math.min(Math.min(costs[n-1][0],costs[n-1][1]),costs[n-1][2]);
    }
}