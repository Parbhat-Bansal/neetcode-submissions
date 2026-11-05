class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0, dp),
                        solve(cost, 1, dp));
    }

    public int solve(int[] cost, int i, int[] dp) {

        if (i >= cost.length) 
        {
            return 0;
        }

        if (dp[i] != -1) 
        {
            return dp[i];
        }

        int one = solve(cost, i + 1, dp);
        int two = solve(cost, i + 2, dp);

        dp[i] = cost[i] + Math.min(one, two);

        return dp[i];
    }
}
