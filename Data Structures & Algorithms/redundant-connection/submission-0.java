class Solution
{
    int[] p;

    public int[] findRedundantConnection(int[][] edges)
    {
        int n = edges.length;
        p = new int[n + 1];

        for (int i = 1; i <= n; i++)
            p[i] = i;

        for (int[] e : edges)
        {
            int a = find(e[0]);
            int b = find(e[1]);

            if (a == b)
                return e;

            p[a] = b;
        }

        return new int[0];
    }

    private int find(int x)
    {
        if (p[x] != x)
            p[x] = find(p[x]);

        return p[x];
    }
}
