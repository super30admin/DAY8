/*
Time Complexity: O(m*n)

Space Complexity: O(n) 
*/

#include<iostream>
#include<vector>


class Solution {
public:
    int change(int amount, std::vector<int>& coins) {
        int numOfRows = coins.size() + 1;
        int numOfColumns = amount + 1;
        int arr [numOfColumns];
        for (int i=1; i < numOfColumns; i++){
            arr[i] = 0;
        }
        arr[0] = 1;
        for (int i = 1; i < numOfRows; i++){
            for(int j=0; j < numOfColumns; j++){
                if (j >= coins[i - 1]){
                    arr[j] = arr[j] + arr[j - coins[i - 1]];
                }
            }
        }
        int result = arr[numOfColumns - 1];
        return result;
    }
};

int main(){
    Solution sol = Solution();
    std::vector<int> arr {1,2,5};
    int k = 5;
    int exp_res = 4;
    int res = sol.change(k, arr);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }

    arr = {2};
    k = 3;
    exp_res = 0;
    res = sol.change(k ,arr);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }
}
