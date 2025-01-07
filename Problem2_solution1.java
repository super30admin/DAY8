// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class  Problem2_solution1{
    public static int recurse(int[][] costs, int row, int col) {
        //Base Confition
        if(row == costs.length) {
            return 0;
        }
        if(col == 0) {
           int col00 =  recurse(costs,row +1, 1);
           int col01 =  recurse(costs,row +1, 2);
           return costs[row][0]+Math.min(col00, col01);
        }if(col ==1) {
            int col00 =  recurse(costs,row +1, 0);
           int col01 =  recurse(costs,row +1, 2);
           return costs[row][1]+Math.min(col00, col01);
        }if(col ==2) {
            int col00 =  recurse(costs,row +1, 0);
           int col01 =  recurse(costs,row +1, 1);
           return costs[row][2]+Math.min(col00, col01);
        }
       return 0; 
    } 
    
     public static void main(String[] args)
  {
 
    int costs[][] = { { 14, 2, 11 },
                     { 11, 14, 5 },
                     { 14, 3, 10 } };
 
    int red =  recurse(costs, 0, 0);
    int blue = recurse(costs, 0,1);
    int green = recurse(costs, 0,2);
    int minCost =  Math.min(red, Math.min(blue, green));
    System.out.println(minCost);

  }
}