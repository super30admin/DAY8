//Time complexity: O(n*m) where n is the number of houses to be painted and m is the number of colors we can paint with.
//Space complexity: O(1) We are not using extra space but manipulating the input array.

class PaintHouse {
    public int minCostToPaintHouses (int[][] costs ) {
        if(costs.length==0 || costs[0].length==0)   return 0;
        
        for(int i=1; i < costs.length; i++)                                                     
        {                                                       //looking backward to check if we have picked this color. 
            costs[i][0]+=Math.min(costs[i-1][1], costs[i-1][2]);//So we keep adding the current column with min cost of painting (between 
            costs[i][1]+=Math.min(costs[i-1][0], costs[i-1][2]);//the options - by not choosing the color we chose in previous row)
            costs[i][2]+=Math.min(costs[i-1][1], costs[i-1][1]);
        }

        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }

    public static void main(String[] args)
    {
        int[][] costs = {{17, 2, 17},{16, 16, 5}, {14, 3, 19}};
        PaintHouse ph = new PaintHouse();
        System.out.println(ph.minCostToPaintHouses(costs));
    }
}