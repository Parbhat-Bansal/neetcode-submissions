class Solution
{
    public List<String> findItinerary(List<List<String>> tickets)
    {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> t : tickets)
        {
            adj.putIfAbsent(t.get(0), new PriorityQueue<>());
            adj.get(t.get(0)).offer(t.get(1));
        }

        List<String> ans = new ArrayList<>();

        dfs("JFK", adj, ans);

        Collections.reverse(ans);

        return ans;
    }

    public void dfs(String s, Map<String, PriorityQueue<String>> adj, List<String> ans)
    {
        PriorityQueue<String> pq = adj.get(s);

        while (pq != null && !pq.isEmpty())
        {
            String next = pq.poll();
            dfs(next, adj, ans);
        }

        ans.add(s);
    }
}