
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> s = new HashSet<>(wordList);
        if (!s.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int n = 1;

        while (!q.isEmpty()) 
        {
            int z = q.size();

            while (z-- > 0) 
            {
                String w = q.poll();

                if (w.equals(endWord)) return n;

                char[] a = w.toCharArray();

                for (int i = 0; i < a.length; i++) 
                {
                    char c = a[i];

                    for (char j = 'a'; j <= 'z'; j++) 
                    {
                        if (j == c) continue;

                        a[i] = j;
                        String t = new String(a);

                        if (s.contains(t)) 
                        {
                            q.offer(t);
                            s.remove(t);
                        }
                    }

                    a[i] = c;
                }
            }

            n++;
        }

        return 0;
    }
}
