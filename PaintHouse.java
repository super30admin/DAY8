class PaintHouse {
    public int minCost(int[][] costs) {
        int n =costs.length;
        int varR=costs[n-1][0];
        int varB=costs[n-1][1];
        int varG=costs[n-1][2];
        for(int i=n-2;i>=0;i--){
            int tempR=varR;
            varR =costs[i][0]+ Math.min(varB,varG);
            int tempB=varB;
            varB = costs[i][1]+Math.min(varG,tempR);

            varG = costs[i][2]+Math.min(tempR,tempB);
        }

        return Math.min(varR,Math.min(varG,varB));
    }
    public static void main(String[] args){
        PaintHouse paintHouse=new PaintHouse();
        paintHouse.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}});
    }
}
/*
 public int minCost(int[][] costs) {
        int reR=helper(costs,0,0);
        int reB=helper(costs,1,0);
        int reG=helper(costs,2,0);
        return Math.min(reR,Math.min(reB,reG));
    }
    private int helper(int[][] costs,int colorIdx,int houseIdx){
    if(houseIdx==costs.length) return 0;
       if(colorIdx==0){
        return costs[houseIdx][0]+Math.min(helper(costs,1,houseIdx+1),helper(costs,2,houseIdx+1));
       }
 if(colorIdx==1){
        return costs[houseIdx][1]+Math.min(helper(costs,0,houseIdx+1),helper(costs,2,houseIdx+1));
       }
 if(colorIdx==2){
        return costs[houseIdx][2]+Math.min(helper(costs,0,houseIdx+1),helper(costs,1,houseIdx+1));
       }
           return 0;
    }

 */

 /*
  int n =costs.length;
          int dp[][] =new int[n][3];
          dp[n-1][0]=costs[n-1][0];
          dp[n-1][1]=costs[n-1][1];
          dp[n-1][2]=costs[n-1][2];
          for(int i=n-2;i>=0;i--){
        costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
        costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
        costs[i][2] += Math.min(costs[i+1][1],costs[i+1][0]);
          }

           return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
  */