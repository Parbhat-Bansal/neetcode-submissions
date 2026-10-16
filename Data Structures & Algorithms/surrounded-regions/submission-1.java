class Solution
{
    public void solve(char[][] b)
    {
        int m = b.length, n = b[0].length;

        for (int i = 0; i < m; i++)
        {
            dfs(b, i, 0);
            dfs(b, i, n - 1);
        }

        for (int j = 0; j < n; j++)
        {
            dfs(b, 0, j);
            dfs(b, m - 1, j);
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (b[i][j] == 'O')
                    b[i][j] = 'X';
                else if (b[i][j] == 'T')
                    b[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] b, int i, int j)
    {
        int m = b.length, n = b[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n
            || b[i][j] != 'O')
            return;

        b[i][j] = 'T';

        dfs(b, i + 1, j);
        dfs(b, i - 1, j);
        dfs(b, i, j + 1);
        dfs(b, i, j - 1);
    }
}