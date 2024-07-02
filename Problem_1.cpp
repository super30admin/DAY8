/*
Time Complexity: O(n)

Space Complexity: O(1) 
*/

#include<iostream>
#include<vector>

class Solution {
public:
    int minCost(std::vector<std::vector<int>>& costs) {
        int numOfRow = costs.size();
        int numOfColumn = costs[0].size();

        int case1 = costs[numOfRow - 1][0];
        int case2 = costs[numOfRow - 1][1];
        int case3 = costs[numOfRow - 1][2];
        for(int i=numOfRow-2; i>=0; i--){
            int temp1 = case1;
            int temp2 = case2;
            case1 = std::min(costs[i][0] + case2, costs[i][0] + case3);
            case2 = std::min(costs[i][1] + temp1, costs[i][1] + case3);
            case3 = std::min(costs[i][2] + temp1, costs[i][2] + temp2);
        }
        return std::min(case1, std::min(case2, case3));
    }
};

int main(){
    Solution sol = Solution();
    std::vector<std::vector<int>> arr {{17,2,17},{16,16,5},{14,3,19}};
    int exp_res = 10;
    int res = sol.minCost(arr);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }

    arr = {{7,6,2}};
    exp_res = 2;
    res = sol.minCost(arr);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }
}
