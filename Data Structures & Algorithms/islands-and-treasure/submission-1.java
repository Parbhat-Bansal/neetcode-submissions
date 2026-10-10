class Solution {
    public void islandsAndTreasure(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 0) 
                {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) 
        {
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];

            for (int[] d : dir) 
            {
                int x = i + d[0];
                int y = j + d[1];

                if (x < 0 || x >= m || y < 0 || y >= n) 
                {
                    continue;
                }

                if (grid[x][y] != Integer.MAX_VALUE) 
                {
                    continue;
                }

                grid[x][y] = grid[i][j] + 1;
                q.offer(new int[]{x, y});
            }
        }
    }
}