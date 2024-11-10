/*
Time Complexity: Time Limit exceeded due to exponential Time complexity 2^(m+n) where m is the number
                  of elements in an array, and n is the total amount

Space Complexity: m+n as that many subproblems would be created to find the path

Did this code successfully run on Leetcode: No as time limit exceeded.

Why Greedy Does Not Work for Counting Combinations:
Greedy does not explore all possible combinations and focuses on local optimizations (such as using the largest coin
first). It would fail in situations like the following:

If you only have coins [1, 2], greedy would pick the largest coin at each step, and it would miss combinations
like [1, 1, 1] in some cases.
 */

//Using Int Based Recursion
class CoinChange2ExhaustiveApproach {
    public int change(int amount, int[] coins) {

        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int i)
    {
        //base case
        if(amount == 0) return 1; //if leaf node is valis we count it as it is one of its path

        if(amount < 0 || i == coins.length) return 0; //Negative number || no coins left so return 0 as we don't have to count this path

        //logic
        //no choose case
        int case0 = helper(coins, amount, i+1);

        //choose case
        int case1 = helper(coins, amount-coins[i], i);

        return case0+case1;
    }
}
/*
Check Video at 22:00 for remaining methods like passing count in helper won't work but passing a count array will work
as we are not sending a primitive data type, we will be passing a data structure, so when data structure goes inside
a stack it will be a pointer, it will be a global scope

Using Void-Based Recursion

class CoinChange2ExhaustiveApproach
{
        int countPaths; //Using Global Variable to keep a count of paths

        public int change(int amount, int[] coins) {
            this.countPaths = 0;
            helper(coins, amount, 0);
            return countPaths;
        }

        private void helper(int[] coins, int amount, int i)
        {
            //base case
            if(amount == 0)
            {
                countPaths++; //if leaf node is valis we count it as it is one of its path
                return;
            }

            if(amount < 0 || i == coins.length) return; //Negative number || no coins left so return 0 as we don't have to count this path

            //logic
            //no choose case
            helper(coins, amount, i+1);

            //choose case
            helper(coins, amount-coins[i], i);
        }
}
*/