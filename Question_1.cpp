#include<bits/stdc++.h>
#include <vector>
#include <iostream>
using namespace std;
int minCost(vector<vector<int>>& costs) {
    int n = costs.size();
    int dp[3][n+1];
    memset(dp,0,sizeof(dp));
    for(int i=n-1;i>=0;i--){
        for(int j=0;j<=2;j++){
            int mini = INT_MAX;
            for(int k=0;k<=2;k++){
                if(j==k) continue;
                mini = min(mini,dp[k][i+1]);
            }
            dp[j][i] = costs[i][j]+mini;
        }
    }
    return min(min(dp[0][0],dp[1][0]),dp[2][0]);
}
int main(){
    vector<vector<int>> costs = {{17,2,17},{16,16,5},{14,3,19}};
    cout<<minCost(costs);
    return 0;
}