class Solution
{
    public List<Integer> majorityElement(int[] a)
    {
        int c1 = 0, c2 = 0;
        int n1 = 0, n2 = 0;

        for (int x : a)
        {
            if (x == c1)
            {
                n1++;
            }
            else if (x == c2)
            {
                n2++;
            }
            else if (n1 == 0)
            {
                c1 = x;
                n1 = 1;
            }
            else if (n2 == 0)
            {
                c2 = x;
                n2 = 1;
            }
            else
            {
                n1--;
                n2--;
            }
        }

        n1 = 0;
        n2 = 0;

        for (int x : a)
        {
            if (x == c1)
            {
                n1++;
            }

            if (x == c2)
            {
                n2++;
            }
        }

        List<Integer> r = new ArrayList<>();

        if (n1 > a.length / 3)
        {
            r.add(c1);
        }

        if (c1 != c2 && n2 > a.length / 3)
        {
            r.add(c2);
        }

        return r;
    }
}
