//Space Complexity: O(NM), where n is number of houses and m is number of colors we can paint, i.e 3.
//Time Complexity: O(NM), where n is the length of the array.
//Executed successfully  on leetcode.

class Solution {    
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size()==0){
            return 0;
        }
        for(int i=1; i< costs.size(); i++){
            costs.at(i).at(0) += min(costs.at(i-1).at(1), costs.at(i-1).at(2));
            costs.at(i).at(1) += min(costs.at(i-1).at(0), costs.at(i-1).at(2));
            costs.at(i).at(2) += min(costs.at(i-1).at(1), costs.at(i-1).at(0));
        }
        return min(costs.at(costs.size()-1).at(0),min(costs.at(costs.size()-1).at(1), costs.at(costs.size()-1).at(2)));
    }
};