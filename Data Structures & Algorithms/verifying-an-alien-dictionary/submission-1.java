class Solution 
{
    public boolean isAlienSorted(String[] words, String order) 
    {
        int[] pos = new int[26];

        for (int i = 0; i < 26; i++) 
        {
            pos[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) 
        {
            String a = words[i];
            String b = words[i + 1];

            int j = 0;
            while (j < a.length() && j < b.length()) 
            {
                if (a.charAt(j) != b.charAt(j)) 
                {
                    if (pos[a.charAt(j) - 'a'] > pos[b.charAt(j) - 'a']) 
                    {
                        return false;
                    }

                    break;
                }
                j++;
            }

            if (j == b.length() && a.length() > b.length()) 
            {
                return false;
            }
        }

        return true;
    }
}