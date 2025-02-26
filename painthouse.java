// time:O(n) n is no of houses as no of colors are constant
// space:O(1)
// without mutating original array
public class painthouse {
    public int minCost(int[][] costs) {
            if(costs == null || costs.length ==0)
            {
                return 0;
            }
            int n = costs.length;
            int red = costs[n-1][0];
            int blue = costs[n-1][1];
            int green = costs[n-1][2];

            for(int i=n-2; i>=0; i--){
                int tempred = red;
                red = costs[i][0] + Math.min(blue, green);
                int tempblue = blue;
                blue = costs[i][1] + Math.min(tempred, green);
                green = costs[i][2] + Math.min(tempred, tempblue);
            }
            return Math.min(red, Math.min(green, blue));
        }
    }

