class Solution
{
    public List<List<String>> accountsMerge(List<List<String>> a)
    {
        Map<String, List<String>> g = new HashMap<>();
        Map<String, String> nm = new HashMap<>();

        for (List<String> x : a)
        {
            String n = x.get(0);

            for (int i = 1; i < x.size(); i++)
            {
                String e = x.get(i);
                nm.put(e, n);
                g.putIfAbsent(e, new ArrayList<>());

                if (i > 1)
                {
                    String p = x.get(i - 1);
                    g.get(e).add(p);
                    g.get(p).add(e);
                }
            }
        }

        Set<String> v = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for (String e : g.keySet())
        {
            if (v.contains(e))
                continue;

            List<String> cur = new ArrayList<>();
            dfs(e, g, v, cur);
            Collections.sort(cur);

            cur.add(0, nm.get(e));
            res.add(cur);
        }

        return res;
    }

    public void dfs(String e, Map<String, List<String>> g,
                     Set<String> v, List<String> cur)
    {
        v.add(e);
        cur.add(e);

        for (String x : g.get(e))
        {
            if (!v.contains(x))
                dfs(x, g, v, cur);
        }
    }
}