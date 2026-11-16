class Solution
{
    public int[][] buildMatrix(int k, int[][] rc, int[][] cc)
    {
        int[] r = topo(k, rc);
        int[] c = topo(k, cc);

        if (r.length == 0 || c.length == 0)
        {
            return new int[0][0];
        }

        int[][] ans = new int[k][k];

        for (int i = 1; i <= k; i++)
        {
            ans[r[i]][c[i]] = i;
        }

        return ans;
    }

    public int[] topo(int k, int[][] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= k; i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] in = new int[k + 1];

        for (int[] e : edges)
        {
            adj.get(e[0]).add(e[1]);
            in[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= k; i++)
        {
            if (in[i] == 0)
            {
                q.offer(i);
            }
        }

        int[] pos = new int[k + 1];
        int idx = 0;

        while (!q.isEmpty())
        {
            int u = q.poll();

            pos[u] = idx++;

            for (int v : adj.get(u))
            {
                in[v]--;

                if (in[v] == 0)
                {
                    q.offer(v);
                }
            }
        }

        if (idx != k)
        {
            return new int[0];
        }

        return pos;
    }
}