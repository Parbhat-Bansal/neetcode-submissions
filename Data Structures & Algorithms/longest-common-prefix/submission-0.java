class Solution 
{

    class TrieNode 
    {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    public void insert(String str) 
    {
        TrieNode curr = root;

        for (char ch : str.toCharArray()) 
        {
            int index = ch - 'a';

            if (curr.children[index] == null) 
            {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public String longestCommonPrefix(String[] strs) 
    {

        for (String str : strs) 
        {
            insert(str);
        }

        StringBuilder ans = new StringBuilder();
        TrieNode curr = root;

        while (!curr.isEnd) 
        {

            int count = 0;
            int index = -1;

            for (int i = 0; i < 26; i++) 
            {
                if (curr.children[i] != null) 
                {
                    count++;
                    index = i;
                }
            }

            if (count != 1) 
            {
                break;
            }

            ans.append((char) ('a' + index));
            curr = curr.children[index];
        }

        return ans.toString();
    }
}
