//Space Complexity: O(1)
//Time Complexity: O(3^n), where n is the length of the array.
//Time Limit exceeded  on leetcode.
class Solution {

private:
    int helper(vector<vector<int>>& costs, int min, int row, int lastColor){
        if(row == costs.size()){
            return min;
        }
        int case1 = INT_MAX;
        int case2 = INT_MAX;
        int case3 = INT_MAX;
        
        if(lastColor == 0){
            case1 = std::min(helper(costs, min+costs.at(row).at(1), row+1, 1),helper(costs, min+costs.at(row).at(2), row+1, 2));
        }
        else if(lastColor == 1){
            case2 = std::min(helper(costs, min+costs.at(row).at(0), row+1, 0),helper(costs, min+costs.at(row).at(2), row+1, 2));
        }
        else{
             case3 = std::min(helper(costs, min+costs.at(row).at(0), row+1, 0),helper(costs, min+costs.at(row).at(1), row+1, 1));
        }
        return std::min(case1, std::min(case2,case3));
    }
    
    
public:
    int minCost(vector<vector<int>>& costs) {
        int case1 = helper(costs, 0, 0, 0);
        int case2 = helper(costs, 0, 0, 1);
        int case3 = helper(costs, 0, 0, 2);
        return std::min(case1,std::min(case2,case3));
    }
};