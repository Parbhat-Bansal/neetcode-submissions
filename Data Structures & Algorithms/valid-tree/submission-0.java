class Solution
{
    public boolean validTree(int n, int[][] edges)
    {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> g = new ArrayList<>();
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());

        for (int[] e : edges)
        {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        dfs(0, g, v);

        for (boolean x : v)
        {
            if (!x)
                return false;
        }

        return true;
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