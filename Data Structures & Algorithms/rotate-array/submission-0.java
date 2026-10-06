class Solution 
{
    public void rotate(int[] a, int k) 
    {
        int n = a.length;
        k %= n;

        rev(a, 0, n - 1);
        rev(a, 0, k - 1);
        rev(a, k, n - 1);
    }

    public void rev(int[] a, int l, int r) 
    {
        while (l < r) 
        {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
    }
}
