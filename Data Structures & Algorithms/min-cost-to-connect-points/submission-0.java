class Solution
{
    public int minCostConnectPoints(int[][] p)
    {
        int n = p.length;

        boolean[] vis = new boolean[n];
        int[] d = new int[n];

        Arrays.fill(d, Integer.MAX_VALUE);

        d[0] = 0;

        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            int u = -1;

            for (int j = 0; j < n; j++)
            {
                if (!vis[j] && (u == -1 || d[j] < d[u]))
                {
                    u = j;
                }
            }

            vis[u] = true;
            ans += d[u];

            for (int v = 0; v < n; v++)
            {
                if (!vis[v])
                {
                    int cost = Math.abs(p[u][0] - p[v][0])
                             + Math.abs(p[u][1] - p[v][1]);

                    d[v] = Math.min(d[v], cost);
                }
            }
        }

        return ans;
    }
}