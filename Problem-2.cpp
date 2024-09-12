//TC O(n)
//SC: O(n);
class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if (n==0)
            return 0;
        if (n==1)
            return nums[0];
        vector<int> maxma(n,0);
        maxma[0] = nums[0];
        maxma[1] = max(nums[0], nums[1]);
        
        if (n==2)
            return maxma[1];
        int i=2;
        
        while (i<n) {
            maxma[i] = max(maxma[i-1], maxma[i-2]+nums[i]);
            i++;
        }
        return maxma[n-1];
    }
};
