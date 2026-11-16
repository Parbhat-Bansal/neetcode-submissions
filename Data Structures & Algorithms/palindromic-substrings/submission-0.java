class Solution
{
    public int countSubstrings(String s)
    {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            ans += expand(s, i, i);
            ans += expand(s, i, i + 1);
        }

        return ans;
    }

    public int expand(String s, int l, int r)
    {
        int cnt = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            cnt++;
            l--;
            r++;
        }

        return cnt;
    }
}