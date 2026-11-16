class Solution
{
    public int numRescueBoats(int[] people, int limit)
    {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int ans = 0;

        while (l <= r)
        {
            if (people[l] + people[r] <= limit)
            {
                l++;
            }

            r--;
            ans++;
        }

        return ans;
    }
}