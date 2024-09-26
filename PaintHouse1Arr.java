package Day9;

public class PaintHouse1Arr {

    public int minCost(int[][] costs){
        int m = costs.length;

        if(costs == null || costs.length == 0) return 0;



        for(int i=1; i<m; i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }

        return Math.min(Math.min(costs[m-1][0], costs[m-1][1]), costs[m-1][2]);
    }

    public static void main(String args[]){
        PaintHouse1Arr obj = new PaintHouse1Arr();

        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};

        System.out.println("The min cost at which the given houses can be painted with adjacent houses not having the same color is: "+ obj.minCost(costs));
    }
}
