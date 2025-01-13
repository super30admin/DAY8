namespace LeetCodeSubmission.DP2;

public class CoinChange2
{
    /*
     * To make amount 0 with 0-denomination coin, I need 1 coin of 0 denomination, thus value is 1
     */

    public int Memorization2D(int amount, int[] coins)
    {
        int[,] memorization2D = new int[coins.GetLength(0)+1,amount+1];
        memorization2D[0, 0] = 1;

        for (int r = 1; r < memorization2D.GetLength(0); r++)
        {
            int denomination = coins[r - 1];
            for (int c = 0; c < memorization2D.GetLength(1); c++)
            {
                // copy everything from above if coin-denomination is greater than amount i.e. c
                if (denomination > c)
                {
                    memorization2D[r, c] = memorization2D[r - 1, c];
                }
                else
                {
                    memorization2D[r, c] = memorization2D[r - 1, c] + memorization2D[r, c - denomination];
                }
            }
        }
        
        //print the memorization2D matrix
        /*for (int r = 0; r < memorization2D.GetLength(0); r++)
        {
            for (int c = 0; c < memorization2D.GetLength(1); c++)
            {
                Console.Write(memorization2D[r,c]);
                Console.Write("\t");
            }
            Console.WriteLine();
        }*/

        // return the result
        return memorization2D[memorization2D.GetLength(0) - 1, memorization2D.GetLength(1) - 1];
    }
    
    public int Change(int amount, int[] coins)
    {
        return this.Memorization2D(amount, coins);
    }
}