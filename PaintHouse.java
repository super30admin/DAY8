public class PaintHouse {
    public int minCost(int[][] costs) {

        int case1 =  helper(costs,0, 0, 0);
        int case2 =  helper(costs,0, 0, 1);
        int case3 =  helper(costs,0, 0, 2);

        return Math.min(case1, Math.min(case2, case3));

    }

    private int helper(int[][] costs, int min, int row, int lastColor){

        if(row == costs.length) return min;

        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;

        if(lastColor == 0){
            case1= Math.min (
                    helper(costs,min + costs[row][1], row + 1, 1),// blue
                    helper(costs,min + costs[row][2], row + 1, 2)// green
            );
        }

        if(lastColor == 1){
            case2= Math.min (
                    helper(costs,min + costs[row][0], row + 1, 0),// blue
                    helper(costs,min + costs[row][2], row + 1, 2)// green
            );
        }

        if(lastColor == 2){
            case3= Math.min (
                    helper(costs,min + costs[row][0], row + 1, 0),// blue
                    helper(costs,min + costs[row][1], row + 1, 1)// green
            );
        }

        return Math.min(case1, Math.min(case2, case3));

    }
}
