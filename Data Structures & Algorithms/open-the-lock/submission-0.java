class Solution
{
    public int openLock(String[] d, String t)
    {
        Set<String> s = new HashSet<>(Arrays.asList(d));
        Queue<String> q = new LinkedList<>();
        Set<String> v = new HashSet<>();

        if (s.contains("0000"))
            return -1;

        q.offer("0000");
        v.add("0000");

        int steps = 0;

        while (!q.isEmpty())
        {
            int sz = q.size();

            while (sz-- > 0)
            {
                String cur = q.poll();

                if (cur.equals(t))
                    return steps;

                for (int i = 0; i < 4; i++)
                {
                    char[] a = cur.toCharArray();

                    for (int x : new int[]{-1, 1})
                    {
                        int nd = (a[i] - '0' + x + 10) % 10;
                        a[i] = (char) (nd + '0');

                        String nxt = new String(a);

                        if (!s.contains(nxt) && v.add(nxt))
                            q.offer(nxt);

                        a[i] = cur.charAt(i);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}