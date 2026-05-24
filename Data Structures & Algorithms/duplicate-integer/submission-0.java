class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean ans = false ;
        int n= nums.length ;
        Set<Integer> h = new HashSet<>();
        for(int i = 0 ; i < n ; i++)
        {
            int val = nums[i] ;
            if(h.contains(val))
            {
                ans = true ;
            }

            h.add(nums[i]);
        }

        return ans ;
        
    }
}