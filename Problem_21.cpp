class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size()==0)
            return 0;
        
        int rows = 3;
        int cols = costs.size();
        
        int dp[rows][cols];
        
        vector<int> col1_fill = costs[0];
        dp[0][0] = col1_fill[0];
        dp[1][0] = col1_fill[1];
        dp[2][0] = col1_fill[2];
        int col_idx=1;
        
        for(int j=1; j<cols; j++){
            for(int i=0; i<rows; i++){
                int min =-1;
                int red = costs[col_idx][0];
                int green = costs[col_idx][1];
                int blue = costs[col_idx][2];
                
                if(i==0){
                    int green = dp[i+1][j-1];
                    int blue = dp[i+2][j-1];
                    if(green>blue) min = blue;
                    else           min = green;
                    dp[i][j]=red+min;
                }
                if(i==1){
                    int red = dp[i-1][j-1];
                    int blue = dp[i+1][j-1];
                    if(red>blue) min = blue;
                    else           min = red;
                    dp[i][j]=green+min;
                }
                
                if(i==2){
                    int red = dp[i-2][j-1];
                    int green = dp[i-1][j-1];
                    if(red>green) min = green;
                    else           min = red;
                    dp[i][j]=blue+min;
                }
                
            }
            col_idx++;
        }
        
        //collect all last columns values
        vector<int> res;
        for(int i=0; i<rows; i++){
            res.push_back(dp[i][cols-1]);
        }
        
        sort(res.begin(), res.end());
        return res[0];
        
    }
};