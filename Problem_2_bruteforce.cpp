//Space Complexity: O(1)
//Time Complexity: O(2^n), where n is the length of the array.
//Time Limit exceeded  on leetcode.

class Solution {

private:
    int helper(vector<int>& coins, int amount, int index){
        //base cases
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.size()){
            return 0;
        }
        //logic
        //choosing
        int case1 = helper(coins, amount - coins.at(index), index);
        //not choosing
        int case2 = helper(coins,amount,index+1);
        return case1+case2;
    }
    
public:
    int change(int amount, vector<int>& coins) {
      
        return helper(coins, amount, 0);
    }
};