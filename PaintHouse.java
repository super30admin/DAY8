class PaintHouse{
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        for(int i = n-2; i < 0; i--){
            costs[i][0] = Math.min(Costs[i+1][1],Costs[i+1][2]);
            costs[i][1] = Math.min(Costs[i+1][0],Costs[i+1][2]);
            costs[i][2] = Math.min(Costs[i+1][0],Costs[i+1][1]);
        }
        return Math.min(Costs[0][0],Math.min(Costs[0][1],Costs[0][2]));
    }
}