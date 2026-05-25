

class Solution 
{
    class MaxHeap
    {
        int[][] heap;
        int size;

        MaxHeap(int capacity)
        {
            heap = new int[capacity][2];
            size = 0;
        }

        void insert(int element, int freq)
        {
            heap[size][0] = element;
            heap[size][1] = freq;

            int idx = size;
            size++;

            // Bubble Up
            while(idx > 0)
            {
                int parent = (idx - 1) / 2;

                // Compare frequencies
                if(heap[parent][1] < heap[idx][1])
                {
                    swap(parent, idx);
                    idx = parent;
                }
                else
                {
                    break;
                }
            }
        }

        // Remove max element
        int[] delete()
        {
            int[] top = heap[0];

            heap[0] = heap[size - 1];
            size--;

            heapify(0);

            return top;
        }

        void heapify(int idx)
        {
            int largest = idx;

            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            if(left < size && heap[left][1] > heap[largest][1])
            {
                largest = left;
            }

            if(right < size && heap[right][1] > heap[largest][1])
            {
                largest = right;
            }

            if(largest != idx)
            {
                swap(largest, idx);
                heapify(largest);
            }
        }

        void swap(int i, int j)
        {
            int temp0 = heap[i][0];
            int temp1 = heap[i][1];

            heap[i][0] = heap[j][0];
            heap[i][1] = heap[j][1];

            heap[j][0] = temp0;
            heap[j][1] = temp1;
        }
    }

    public int[] topKFrequent(int[] nums, int k) 
    {
        // Frequency Map
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        MaxHeap mh = new MaxHeap(map.size());

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            mh.insert(entry.getKey(), entry.getValue());
        }

        int[] ans = new int[k];

        for(int i = 0; i < k; i++)
        {
            ans[i] = mh.delete()[0];
        }

        return ans;
    }
}