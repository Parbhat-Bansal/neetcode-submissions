class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {

        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        
        for(int value : m.values())
        {
            pq.add(value);
        }

        int[] ans = new int[k];
        int idx = 0;

    
        while(k > 0)
        {
            int freq = pq.poll();

            for(int key : m.keySet())
            {
                if(m.get(key) == freq)
                {
                    ans[idx++] = key;
                    m.put(key, -1); 
                    break;
                }
            }

            k--;
        }

        return ans;
    }
}