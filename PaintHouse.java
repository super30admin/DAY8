public class PaintHouse {
    //time complexity: O(n)
    //space complexity: O(1)
    //thought process:
    //1. start from the last row and move up
    //2. for each row, update the cost of painting the house with the minimum cost of painting the next row
    //3. return the minimum cost of painting the first row
    public int minCost(int[][] costs) {
       
        for (int i = costs.length-2; i>=0;i--){
         costs[i][0] = costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);
         costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
         costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
        }
        return Math.min (costs[0][0],Math.min(costs[0][1], costs[0][2]));
     }
}
