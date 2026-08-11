class Solution 
{
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void dfs(char[][] grid, int i, int j, int row, int col)
    {
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0')
        {
            return;
        }
        
        grid[i][j] = '0';

        for(int k = 0; k < 4; k++)
        {
            int ni = i + dx[k];
            int nj = j + dy[k];

            dfs(grid, ni, nj, row, col);
        }
    }

    public int numIslands(char[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i < n; i++)   
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }

        return count;
    }
}