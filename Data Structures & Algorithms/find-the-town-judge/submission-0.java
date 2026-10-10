class Solution 
{
    public int findJudge(int n, int[][] trust) 
    {
        int[] a = new int[n + 1];

        for (int[] t : trust) 
        {
            a[t[0]]--;
            a[t[1]]++;
        }

        for (int i = 1; i <= n; i++) 
        {
            if (a[i] == n - 1) 
            {
                return i;
            }
        }

        return -1;
    }
}