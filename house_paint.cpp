//Time O(n)
//Space O(3n)--> O(n)
//Leetcode : yes
//Issue seen: none
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n= costs.size();
        vector<int>red(n,0);
        vector<int>blue(n,0);
        vector<int>green(n,0);

        red[0] = costs[0][0];
        blue[0] = costs[0][1];
        green[0] = costs[0][2];

        for(int i=1; i<n; i++) {
            red[i] = costs[i][0] + min(blue[i-1], green[i-1]);
            blue[i] = costs[i][1] + min(red[i-1], green[i-1]);
            green[i] = costs[i][2] + min(blue[i-1], red[i-1]);
        }
        int temp = min(red[n-1], blue[n-1]);
        return min(temp, green[n-1]);
        
    }
};
