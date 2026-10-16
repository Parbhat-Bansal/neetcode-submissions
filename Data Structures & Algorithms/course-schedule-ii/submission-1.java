class Solution
{
    public int[] findOrder(int n, int[][] p)
    {
        List<List<Integer>> g = new ArrayList<>();
        int[] in = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());

        for (int[] a : p)
        {
            g.get(a[1]).add(a[0]);
            in[a[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            if (in[i] == 0)
                q.offer(i);
        }

        int idx = 0;

        while (!q.isEmpty())
        {
            int u = q.poll();
            res[idx++] = u;

            for (int v : g.get(u))
            {
                in[v]--;

                if (in[v] == 0)
                    q.offer(v);
            }
        }

        return idx == n ? res : new int[0];
    }
}