class Solution
{
    public int numDecodings(String s)
    {
        int n = s.length();

        if (s.charAt(0) == '0')
        {
            return 0;
        }

        int a = 1;
        int b = 1;

        for (int i = 1; i < n; i++)
        {
            int c = 0;

            if (s.charAt(i) != '0')
            {
                c += b;
            }

            int x = Integer.parseInt(s.substring(i - 1, i + 1));

            if (x >= 10 && x <= 26)
            {
                c += a;
            }

            a = b;
            b = c;
        }

        return b;
    }
}