class Solution {
    public int[] sortArray(int[] nums) 
    {
        for(int idx = 1; idx < nums.length; idx++)
        {
            int idx1 = idx - 1;
            while(idx1 >= 0 && nums[idx1 + 1] < nums[idx1])
            {
                int tmp = nums[idx1 + 1];
                nums[idx1 + 1] = nums[idx1];
                nums[idx1] = tmp;
                idx1 -=1;
            }
        }
        return nums;
    }
}