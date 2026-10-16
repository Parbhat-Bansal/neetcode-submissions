class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) 
        {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> g = new ArrayList<>();
        int[] d = new int[n];

        for (int i = 0; i < n; i++) 
        {
            g.add(new ArrayList<>());
        }

        for (int[] e : edges) 
        {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
            d[e[0]]++;
            d[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) 
        {
            if (d[i] == 1) 
            {
                q.offer(i);
            }
        }

        while (n > 2) 
        {
            int sz = q.size();
            n -= sz;

            while (sz-- > 0) 
            {
                int u = q.poll();

                for (int v : g.get(u)) 
                {
                    d[v]--;

                    if (d[v] == 1) 
                    {
                        q.offer(v);
                    }
                }
            }
        }

        while (!q.isEmpty()) 
        {
            ans.add(q.poll());
        }

        return ans;
    }
}