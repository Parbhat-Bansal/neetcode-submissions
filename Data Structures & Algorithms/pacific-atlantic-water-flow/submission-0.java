class Solution 
{

    public List<List<Integer>> pacificAtlantic(int[][] h) 
    {

        int m = h.length;
        int n = h[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++) 
        {
            dfs(i, 0, h, p);
            dfs(i, n - 1, h, a);
        }

        for (int j = 0; j < n; j++) 
        {
            dfs(0, j, h, p);
            dfs(m - 1, j, h, a);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (p[i][j] && a[i][j]) 
                {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int r, int c, int[][] h, boolean[][] v) 
    {

        if (v[r][c]) 
        {
            return;
        }

        v[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) 
        {
            int x = r + dr[i];
            int y = c + dc[i];

            if (x >= 0 && x < h.length &&
                y >= 0 && y < h[0].length &&
                !v[x][y] && h[x][y] >= h[r][c]) 
                {

                    dfs(x, y, h, v);
                }
        }
    }
}