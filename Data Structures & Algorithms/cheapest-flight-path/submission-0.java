class Solution
{
    public int findCheapestPrice(int n, int[][] f, int src, int dst, int k)
    {
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);

        d[src] = 0;

        for (int i = 0; i <= k; i++)
        {
            int[] temp = d.clone();

            for (int[] x : f)
            {
                int u = x[0];
                int v = x[1];
                int w = x[2];

                if (d[u] != Integer.MAX_VALUE)
                {
                    temp[v] = Math.min(temp[v], d[u] + w);
                }
            }

            d = temp;
        }

        return d[dst] == Integer.MAX_VALUE ? -1 : d[dst];
    }
}