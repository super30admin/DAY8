#include<bits/stdc++.h>
#include <vector>
#include <iostream>
using namespace std;
int change(int amount, vector<int>& coins) {
    int n = coins.size();
    int dp[amount+1][n];
    memset(dp,0,sizeof(dp));
    sort(coins.begin(),coins.end());
    for(int i=1;i<=n-1;i++) dp[0][i]=1;
    for(int m=0;m<=amount;m++)  dp[m][0]=((m%coins[0])==0);
    
    for(int ind=1;ind<=n-1;ind++){
        for(int m=1;m<=amount;m++){
            if(m>=coins[ind])dp[m][ind]+=dp[m-coins[ind]][ind];
            dp[m][ind]+=dp[m][ind-1];
            //cout<<m<<" "<<ind<<" "<<dp[m][ind]<<endl;
        }
    }
    return dp[amount][n-1];
}
int main(){
    vector<int> coins = {1,2,5};
    int amount = 5;
    cout<<change(amount,coins);
    return 0;
}