class Solution
{
    public int swimInWater(int[][] g)
    {
        int n = g.length;

        boolean[][] vis = new boolean[n][n];

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{g[0][0], 0, 0});

        while (!pq.isEmpty())
        {
            int[] cur = pq.poll();

            int t = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (vis[r][c])
            {
                continue;
            }

            vis[r][c] = true;

            if (r == n - 1 && c == n - 1)
            {
                return t;
            }

            for (int[] x : dir)
            {
                int nr = r + x[0];
                int nc = c + x[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || vis[nr][nc])
                {
                    continue;
                }

                int nt = Math.max(t, g[nr][nc]);

                pq.offer(new int[]{nt, nr, nc});
            }
        }

        return -1;
    }
}