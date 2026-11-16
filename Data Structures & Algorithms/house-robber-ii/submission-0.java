class Solution
{
    public int rob(int[] nums)
    {
        int n = nums.length;

        if (n == 1)
        {
            return nums[0];
        }

        return Math.max(
            solve(nums, 0, n - 2),
            solve(nums, 1, n - 1)
        );
    }

    public int solve(int[] nums, int s, int e)
    {
        int a = 0;
        int b = 0;

        for (int i = s; i <= e; i++)
        {
            int c = Math.max(b, a + nums[i]);

            a = b;
            b = c;
        }

        return b;
    }
}