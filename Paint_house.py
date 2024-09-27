#Time complexity - O(mn)
#space complexity - O(1)
#complied successfully on leetcode- Not done on leetcode but wrote this in IDE.THink it covers all the test cases.
#ANy problems faced - None

#Code Description:
#In this problem we start with second row and checks the for the minimum element from the previous row in three locations.we use to fill the# remaining matrix with the same procedure till we reach the last element.In the end we take the minimum element from the last row which is #the ouput of the given problem.

def painthouse(nums):
    if nums==None or len(nums)==0:
        return 0
    for i in range(1,len(nums)):
        for j in range(len(nums[0])):
            if j==0:
                nums[i][j]=nums[i][j]+min(nums[i-1][j],nums[i-1][j+1])
            elif j==len(nums[0])-1:
                nums[i][j]=nums[i][j]+min(nums[i-1][j],nums[i-1][j-1])
            else:
                nums[i][j]=nums[i][j]+min(nums[i-1][j],nums[i-1][j-1],nums[i-1][j+1])
    mini=float('inf')
    for j in range(len(nums[0])):
        if nums[len(nums)-1][j]<=mini:
            mini=nums[len(nums)-1][j]
    return mini

nums=[[17,2,17],[16,16,5],[14,3,19]]
print(painthouse(nums))