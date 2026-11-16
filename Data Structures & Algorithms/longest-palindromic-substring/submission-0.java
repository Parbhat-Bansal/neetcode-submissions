class Solution
{
    public String longestPalindrome(String s)
    {
        int n = s.length();

        int st = 0;
        int max = 0;

        for (int i = 0; i < n; i++)
        {
            int a = expand(s, i, i);
            int b = expand(s, i, i + 1);

            int len = Math.max(a, b);

            if (len > max)
            {
                max = len;
                st = i - (len - 1) / 2;
            }
        }

        return s.substring(st, st + max);
    }

    public int expand(String s, int l, int r)
    {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }

        return r - l - 1;
    }
}