namespace LeetCodeSubmission.DP2;

public class ClassPaintHouses
{
    public int MinCost(int[][] costs) {
        
        // mutate the original matrix
        int rows = costs.GetLength(0);
        int cols = costs[0].GetLength(0);

        for (int r = rows - 2; r > -1; r--)
        {
            for (int c = cols - 1; c > -1; c--)
            {
                // cols will be fixed to 3, rows can be n
                if (c == 2)
                {
                    costs[r][c] += Math.Min(costs[r + 1][c - 1], costs[r + 1][c - 2]);
                }
                else if (c == 1)
                {
                    costs[r][c] += Math.Min(costs[r + 1][c - 1], costs[r + 1][c + 1]);
                }
                else if (c == 0)
                {
                    costs[r][c] += Math.Min(costs[r + 1][c + 1], costs[r + 1][c + 2]);
                }
            }
        }
        
        // print the mutated matrix
        /*for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                Console.Write(costs[r][c]);
                Console.Write("\t");
            }
            Console.WriteLine();
        }*/

        // find the minimum in first row 
        int minValue = int.MaxValue;
        for (int i = 0; i < cols; i++)
        {
            minValue = Math.Min(minValue, costs[0][i]);
        }
        
        return minValue;
    }
}