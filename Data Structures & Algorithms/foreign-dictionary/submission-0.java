class Solution
{
    public String foreignDictionary(String[] words)
    {
        List<Set<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++)
        {
            adj.add(new HashSet<>());
        }

        int[] in = new int[26];
        boolean[] vis = new boolean[26];

        for (String s : words)
        {
            for (char c : s.toCharArray())
            {
                vis[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++)
        {
            String a = words[i];
            String b = words[i + 1];

            int len = Math.min(a.length(), b.length());
            boolean found = false;

            for (int j = 0; j < len; j++)
            {
                if (a.charAt(j) != b.charAt(j))
                {
                    int u = a.charAt(j) - 'a';
                    int v = b.charAt(j) - 'a';

                    if (adj.get(u).add(v))
                    {
                        in[v]++;
                    }

                    found = true;
                    break;
                }
            }

            if (!found && a.length() > b.length())
            {
                return "";
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < 26; i++)
        {
            if (vis[i])
            {
                cnt++;

                if (in[i] == 0)
                {
                    q.offer(i);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty())
        {
            int u = q.poll();

            ans.append((char) (u + 'a'));

            for (int v : adj.get(u))
            {
                in[v]--;

                if (in[v] == 0)
                {
                    q.offer(v);
                }
            }
        }

        if (ans.length() != cnt)
        {
            return "";
        }

        return ans.toString();
    }
}