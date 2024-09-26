// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Could not check all Leetcode conditions


// Your code here along with comments explaining your approach
//CODE IN C++//

int calcpainthouses(int p[][3]) //function takes array as argument
{
    int m=p[0][0]; //initializing iterator as m
    int min_cost=0; //declaring cost as 0
    int r = sizeof(p[0])/sizeof(p[0][0]);
    for(int i=0;i<r;i++) //run the loop for N = size of column iterations
    {      
                m=min(min(p[i][0],p[i][1]),p[i][2]); //calculate the min of paint cost from every row
                 min_cost+=m; //add iterator value to the min cost
    }
    return min_cost;
}


int main() 
{
    int p[][4]={{5,3,2},{4,10,7},{6,2,1},{9,4,1}};
    int cost=0;
    cost=calcpainthouses(p);
    cout<<cost;
}
