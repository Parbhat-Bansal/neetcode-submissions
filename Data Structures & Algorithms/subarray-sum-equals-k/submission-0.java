class Solution
{
    public int subarraySum(int[] a, int k)
    {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);

        int s = 0;
        int c = 0;

        for (int x : a)
        {
            s += x;

            if (m.containsKey(s - k))
            {
                c += m.get(s - k);
            }

            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        return c;
    }
}
