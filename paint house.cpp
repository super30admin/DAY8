// paint house
// approach: maintain array of min cost till now for all houses for all colors (nx3). the min of the last row will be the sol. for intermediate houses, sol for a color will be the curr color cost + the min of the costs of the prev house for the other 2 colors (prev row from the arr we are maintaining, not the original costs array)
// time: O(n*3) ~ O(n)
// space: O(n*3) ~ O(n)

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        int all[n][3];
        
        // n = 1 optimization here
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 0) {
                    all[i][j] = costs[i][j];
                }
                else {
                    if(j == 0) {
                        all[i][j] = costs[i][j] + min(all[i-1][1],all[i-1][2]);
                    }
                    else if(j == 1) {
                        all[i][j] = costs[i][j] + min(all[i-1][0],all[i-1][2]);
                    }
                    else {
                        all[i][j] = costs[i][j] + min(all[i-1][0],all[i-1][1]);
                    }
                }
                cout<<all[i][j]<<endl;
            }
        }
        int ans = min(all[n-1][0],all[n-1][1]);
        ans = min(ans,all[n-1][2]);
        return ans;
    }
};