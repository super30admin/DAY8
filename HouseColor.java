//TC: O(M*N)
//SC: O(1)


//This problem was asked at Amazon

// Given a row of n houses, each house can be coloured with any of the three colours: let these be red blue or green.
//the cost for painting a particular house with a particular colour is going to be different.
//you have to colour the house in such a way that no two adjacent houses will have the same colour.
//the cost for painting  a house with any colour is represented by a n X 3 cost matrix 
//where cost for painting house 0 with colour red is cost[0][0] and cost for painting house 4 with green colour is cost[4][2] 
//and so on.....calculate the minimum cost to paint all houses. try to optimize it for space !! 






class Solution
{
    public int minCost(int [][] costs)
    {
        int[] prev = costs[0];
        for (int i =1 ; i< costs.length; ++i)
        {
            int[] curr = new int[3];
            //RED
            curr[0] = costs[i][0] + Math.min(prev[1], prev[2]);

            //GREEN
            curr[1] = costs[i][1] + Math.min(prev[0], prev[2]);


            //BLUE
            curr[2] = costs[i][2] + Math.min(prev[0], prev[2]);

            prev = curr;
        }

        return Math.min(
                prev[0],
                Math.min(prev[1], prev[2])
        );
    }
}

// 




