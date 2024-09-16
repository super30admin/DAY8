//Time Complexity =O(2^(N))
//Space Complexity = O(1)
//Where N is the number of rows in matrix. 
class Solution {
public:
    int helper(vector<vector<int>>& costs, int row, int color, int mincost)
    {
        //base case
        if(row==costs.size())
            return mincost;
        
        //logic
        if(color == 0)
            return min(helper(costs, row+1 , 1 , mincost+costs[row][0]),helper(costs, row+1 , 2 , mincost+costs[row][0]));
        if(color ==1)
            return min(helper(costs, row+1 , 0 , mincost+costs[row][1]),helper(costs, row+1 , 2 , mincost+costs[row][1]));
 
            return min(helper(costs, row+1 , 1 , mincost+costs[row][2]),helper(costs, row+1 , 0 , mincost+costs[row][2]));
    }
    int minCost(vector<vector<int>>& costs) {
        int case0 = helper(costs, 0, 0, 0);
        int case1 = helper(costs, 0, 1, 0);
        int case2 = helper(costs, 0, 2, 0);
        return min(case0,min(case1,case2));
    }
};



//Time Complexity =O(N)
//Space Complexity = O(1)                               if interviewer tell us that we can change the given matrix.
//                   O(N)                               if interviewer tell us that the given matrix can't be changed.
//Where N is the number of rows in matrix. 
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        for(int i=costs.size()-2;i>=0;i--)
            for(int j=0;j<=3;j++)
            {
                if(j==0)
                    costs[i][j] = costs[i][j] + min(costs[i+1][1],costs[i+1][2]);
                else if(j==1)
                    costs[i][j] = costs[i][j] + min(costs[i+1][0],costs[i+1][2]);
                else
                    costs[i][j] = costs[i][j] + min(costs[i+1][1],costs[i+1][0]);
            }
        return min(costs[0][0],min(costs[0][1],costs[0][2]));
    }
};

//Time Complexity = O(N)
//Space Complexity = O(1)
//Where N is the number of rows in matrix. 
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size()==1)
            return min(costs[0][0], min(costs[0][1],costs[0][2]));
        int r=costs[costs.size()-2][0],g=costs[costs.size()-2][1],b=costs[costs.size()-2][2],rtemp = costs[costs.size()-1][0], gtemp = costs[costs.size()-1][1],btemp = costs[costs.size()-1][2];
        for(int i=costs.size()-2;i>=0;i--)
        {
            r = costs[i][0] + min(gtemp,btemp);
            g = costs[i][1] + min(btemp,rtemp);
            b = costs[i][2] + min(rtemp,gtemp);
            rtemp = r;
            gtemp = g;
            btemp = b;
        }
        return min(r, min(g,b)); 
    }
};
