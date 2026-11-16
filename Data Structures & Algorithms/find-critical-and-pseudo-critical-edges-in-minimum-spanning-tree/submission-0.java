class Solution
{
    int[] p;
    int[] r;

    public int find(int x)
    {
        if (p[x] != x)
        {
            p[x] = find(p[x]);
        }

        return p[x];
    }

    public boolean union(int a, int b)
    {
        int x = find(a);
        int y = find(b);

        if (x == y)
        {
            return false;
        }

        if (r[x] < r[y])
        {
            p[x] = y;
        }
        else if (r[x] > r[y])
        {
            p[y] = x;
        }
        else
        {
            p[y] = x;
            r[x]++;
        }

        return true;
    }

    public int mst(int n, int[][] e, int skip, int take)
    {
        p = new int[n];
        r = new int[n];

        for (int i = 0; i < n; i++)
        {
            p[i] = i;
        }

        int cost = 0;
        int cnt = 0;

        if (take != -1)
        {
            int[] x = e[take];

            union(x[0], x[1]);
            cost += x[2];
            cnt++;
        }

        for (int i = 0; i < e.length; i++)
        {
            if (i == skip || i == take)
            {
                continue;
            }

            int[] x = e[i];

            if (union(x[0], x[1]))
            {
                cost += x[2];
                cnt++;
            }
        }

        return cnt == n - 1 ? cost : Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges)
    {
        int m = edges.length;

        int[][] e = new int[m][4];

        for (int i = 0; i < m; i++)
        {
            e[i] = new int[]{
                edges[i][0],
                edges[i][1],
                edges[i][2],
                i
            };
        }

        Arrays.sort(e, (a, b) -> a[2] - b[2]);

        int base = mst(n, e, -1, -1);

        List<Integer> c = new ArrayList<>();
        List<Integer> pc = new ArrayList<>();

        for (int i = 0; i < m; i++)
        {
            if (mst(n, e, i, -1) > base)
            {
                c.add(e[i][3]);
            }
            else if (mst(n, e, -1, i) == base)
            {
                pc.add(e[i][3]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(c);
        ans.add(pc);

        return ans;
    }
}