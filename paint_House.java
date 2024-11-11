class Solution {
    public int minCost(int[][] costs) {
        for(int j=1;j<costs.length;j++){
            for(int i=0;i<costs[0].length;i++){
                if(i==0)
                costs[j][0]=costs[j][0]+Math.min(costs[j-1][1],costs[j-1][2]);
                if(i==1)
                costs[j][i]=costs[j][i]+Math.min(costs[j-1][0],costs[j-1][2]);
                if(i==2)
                costs[j][i]=costs[j][i]+Math.min(costs[j-1][0],costs[j-1][1]);
            }
        }
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}