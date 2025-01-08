//Tc: O(n)
//SC: O(1)


public class paintHouse {
    public intminCosts(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        //start from the last row and moving up
        for (int i = n-2;i>=0;i--){
            // update the cost of painting the house with the minimum cost of painting for each row,from  row below row

            costs[i][0] = costs[i][0] + math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1] + math.min(costs[i+1][2],costs[i+1][0]);
            costs[i][2] = costs[i][2] + math.min(costs[i+1][0],costs[i+1][1]);
        }
        //return the minimum cost of painting the first row
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}
