// Time Complexity: O(n) // assuming three paint colors it is constant so n
// Space complexity: O(n)
// Did this code successfully run on Naukri(code360) : Yes

//Approach: Dynamic Programming
// 1. We will create a dp array of size n*3, where n is the number of houses and 3 is the number of colors.
// 2. We will fill the last row of the dp array with the cost of painting the first house with the respective colors.
// 3. Then we will iterate from the second last row and fill the dp array with the minimum cost of painting the house with the respective color.

int minCost(vector<vector<int>> &cost)
{
	//	Write your code here.
	int n = cost.size();
	vector<vector<int>> dp(n, vector<int> (3));
	dp[n - 1][0] = cost[n - 1][0];
	dp[n - 1][1] = cost[n - 1][1];
	dp[n - 1][2] = cost[n - 1][2];

	for(int i = n - 2; i >= 0; i--){
		dp[i][0] = cost[i][0] + min(dp[i + 1][1], dp[i + 1][2]);
		dp[i][1] = cost[i][1] + min(dp[i + 1][0], dp[i + 1][2]);
		dp[i][2] = cost[i][2] + min(dp[i + 1][0], dp[i + 1][1]);
	}
	return min(dp[0][0], min(dp[0][1], dp[0][2]));

}