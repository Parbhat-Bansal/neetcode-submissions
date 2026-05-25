class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> m = new HashMap<>();

        for(int num : nums)
        {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] table = new ArrayList[nums.length + 1];

        for(int key : m.keySet())
        {
            int freq = m.get(key);

            if (table[freq] == null) 
            {
                table[freq] = new ArrayList<>();
            }
            
            table[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;

        for(int i = table.length - 1; i >= 0; i--)        
        {
            if(table[i] != null)
            {
                for(int num : table[i])
                {
                    ans[idx++] = num;

                    if (idx == k) 
                    {
                        return ans;
                    }
                
                }
            }
        }
        return ans ;
    }
}