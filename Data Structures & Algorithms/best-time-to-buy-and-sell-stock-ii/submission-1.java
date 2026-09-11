class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int ans=0;
        if(prices.length <= 1) return 0;

        int buy = prices[0];
        for(int i = 0 ; i < prices.length ; i++)
        {
            if(prices[i] > buy) 
            {
                ans= ans + prices[i] - buy;
                buy = prices[i];
            }
            else
            {
                buy = prices[i];
            }
        }
        return ans;
    }
}