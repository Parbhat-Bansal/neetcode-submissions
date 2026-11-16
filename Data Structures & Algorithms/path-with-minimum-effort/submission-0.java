class Solution
{
    public int minimumEffortPath(int[][] h)
    {
        int n = h.length;
        int m = h[0].length;

        int[][] d = new int[n][m];

        for (int[] a : d)
        {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        d[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty())
        {
            int[] cur = pq.poll();

            int e = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == n - 1 && c == m - 1)
            {
                return e;
            }

            if (e > d[r][c])
            {
                continue;
            }

            for (int[] x : dir)
            {
                int nr = r + x[0];
                int nc = c + x[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                {
                    continue;
                }

                int ne = Math.max(e, Math.abs(h[r][c] - h[nr][nc]));

                if (ne < d[nr][nc])
                {
                    d[nr][nc] = ne;
                    pq.offer(new int[]{ne, nr, nc});
                }
            }
        }

        return 0;
    }
}