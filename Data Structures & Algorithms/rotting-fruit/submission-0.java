class Solution 
{
    class tupple
    {
        int i ;
        int j ;
        int count ;

        tupple(int i , int j , int count)
        {
            this.i = i ;
            this.j = j ;
            this.count = count ;
        }
    }
    public int orangesRotting(int[][] grid) 
    {

    
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int n = grid.length ;
        int m = grid[0].length ;        
        
        Queue<tupple> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int fresh = 0;

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j ++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new tupple(i , j , 0));
                    vis[i][j] = true ;
                }

                if(grid[i][j] == 1) fresh ++;
            }
        }
        if(fresh == 0) return 0 ;

        tupple curr = null ;
        while(!q.isEmpty())
        {
            curr = q.poll();
                
            for(int k = 0 ; k < 4 ; k++)
            {
                int nr = curr.i + dr[k];
                int nc = curr.j + dc[k];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1 || vis[nr][nc] == true ) continue ;

                vis[nr][nc] = true ;

                q.add(new tupple(nr , nc , curr.count + 1 ));
                fresh --; 
            }
        
        }
        
        return fresh == 0 ? curr.count : -1 ;
    }
}

