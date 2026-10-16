class Solution
{
    public int countComponents(int n, int[][] edges)
    {
        List<List<Integer>> g = new ArrayList<>();
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());

        for (int[] e : edges)
        {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        int cnt = 0;

        for (int i = 0; i < n; i++)
        {
            if (!v[i])
            {
                dfs(i, g, v);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int u, List<List<Integer>> g, boolean[] v)
    {
        v[u] = true;

        for (int x : g.get(u))
        {
            if (!v[x])
                dfs(x, g, v);
        }
    }
}