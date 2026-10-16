class Solution
{
    public double[] calcEquation(List<List<String>> e, double[] val, List<List<String>> q)
    {
        Map<String, Map<String, Double>> g = new HashMap<>();

        for (int i = 0; i < e.size(); i++)
        {
            String a = e.get(i).get(0);
            String b = e.get(i).get(1);

            g.putIfAbsent(a, new HashMap<>());
            g.putIfAbsent(b, new HashMap<>());

            g.get(a).put(b, val[i]);
            g.get(b).put(a, 1.0 / val[i]);
        }

        double[] res = new double[q.size()];

        for (int i = 0; i < q.size(); i++)
        {
            String a = q.get(i).get(0);
            String b = q.get(i).get(1);

            res[i] = dfs(a, b, g, new HashSet<>());
        }

        return res;
    }

    public double dfs(String a, String b,
                       Map<String, Map<String, Double>> g,
                       Set<String> v)
    {
        if (!g.containsKey(a) || !g.containsKey(b))
            return -1.0;

        if (a.equals(b))
            return 1.0;

        v.add(a);

        for (String x : g.get(a).keySet())
        {
            if (v.contains(x))
                continue;

            double r = dfs(x, b, g, v);

            if (r != -1.0)
                return g.get(a).get(x) * r;
        }

        return -1.0;
    }
}