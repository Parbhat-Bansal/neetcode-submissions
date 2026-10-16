class Solution
{
    public boolean canFinish(int n, int[][] p)
    {
        List<List<Integer>> g = new ArrayList<>();
        int[] in = new int[n];

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

        int cnt = 0;

        while (!q.isEmpty())
        {
            int u = q.poll();
            cnt++;

            for (int v : g.get(u))
            {
                in[v]--;

                if (in[v] == 0)
                    q.offer(v);
            }
        }

        return cnt == n;
    }
}