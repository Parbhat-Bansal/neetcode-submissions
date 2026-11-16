class Solution
{
    public int networkDelayTime(int[][] t, int n, int k)
    {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] x : t)
        {
            adj.get(x[0]).add(new int[]{x[1], x[2]});
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        d[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty())
        {
            int[] cur = pq.poll();

            int u = cur[0];
            int w = cur[1];

            if (w > d[u])
            {
                continue;
            }

            for (int[] x : adj.get(u))
            {
                int v = x[0];
                int wt = x[1];

                if (w + wt < d[v])
                {
                    d[v] = w + wt;
                    pq.offer(new int[]{v, d[v]});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++)
        {
            if (d[i] == Integer.MAX_VALUE)
            {
                return -1;
            }

            ans = Math.max(ans, d[i]);
        }

        return ans;
    }
}