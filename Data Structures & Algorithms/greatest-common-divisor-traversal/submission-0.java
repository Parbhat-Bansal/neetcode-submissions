class Solution
{
    int[] p;
    int[] r;

    public int find(int x)
    {
        if (p[x] != x)
        {
            p[x] = find(p[x]);
        }

        return p[x];
    }

    public void union(int a, int b)
    {
        int x = find(a);
        int y = find(b);

        if (x == y)
        {
            return;
        }

        if (r[x] < r[y])
        {
            p[x] = y;
        }
        else if (r[x] > r[y])
        {
            p[y] = x;
        }
        else
        {
            p[y] = x;
            r[x]++;
        }
    }

    public boolean canTraverseAllPairs(int[] nums)
    {
        int n = nums.length;

        if (n == 1)
        {
            return true;
        }

        int max = 0;

        for (int x : nums)
        {
            max = Math.max(max, x);
        }

        p = new int[n];
        r = new int[n];

        for (int i = 0; i < n; i++)
        {
            p[i] = i;
        }

        int[] last = new int[max + 1];

        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++)
        {
            if (nums[i] == 1)
            {
                return false;
            }

            int x = nums[i];

            for (int j = 2; j * j <= x; j++)
            {
                if (x % j == 0)
                {
                    if (last[j] != -1)
                    {
                        union(i, last[j]);
                    }
                    else
                    {
                        last[j] = i;
                    }

                    while (x % j == 0)
                    {
                        x /= j;
                    }
                }
            }

            if (x > 1)
            {
                if (last[x] != -1)
                {
                    union(i, last[x]);
                }
                else
                {
                    last[x] = i;
                }
            }
        }

        int root = find(0);

        for (int i = 1; i < n; i++)
        {
            if (find(i) != root)
            {
                return false;
            }
        }

        return true;
    }
}