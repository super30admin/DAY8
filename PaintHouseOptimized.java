public class PaintHouseOptimized {
    public static int paintCosts(int[][] costs) {
        int houses = costs.length;

        //Assigning the initial R,B,G as the same values of costs bottom row
        int red = costs[houses-1][0];
        int blue = costs[houses-1][1];
        int green = costs[houses-1][2];

        for(int i=houses-2; i>=0; i--) { //O(n) T.C
            //At each preceding row, adding the current column value
            //and the minimum between the other two colored values from below row.
            int tempR = red;
            red = costs[i][0] + Math.min(blue, green);
            int tempB = blue;
            blue = costs[i][1] + Math.min(tempR, green);
            green = costs[i][2] + Math.min(tempR, tempB); //O(1) S.C
        }

        return Math.min(red , Math.min(blue, green));
    }

    public static void main(String[] args) {
        int[][] costs1 = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("The minimum cost of painting houses with given costs1 is " + paintCosts(costs1));

        int[][] costs2 = {{13,5,29},{14,15,17},{21,4,16},{12,11,8},{9,19,10}};
        System.out.println("The minimum cost of painting houses with given costs2 is " + paintCosts(costs2));
    }
}

