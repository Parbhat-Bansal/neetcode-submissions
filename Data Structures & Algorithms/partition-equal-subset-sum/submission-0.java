class Solution
{
    public boolean canPartition(int[] nums)
    {
        int sum = 0;

        for (int x : nums)
        {
            sum += x;
        }

        if (sum % 2 != 0)
        {
            return false;
        }

        int t = sum / 2;

        boolean[] dp = new boolean[t + 1];

        dp[0] = true;

        for (int x : nums)
        {
            for (int j = t; j >= x; j--)
            {
                dp[j] = dp[j] || dp[j - x];
            }
        }

        return dp[t];
    }
}