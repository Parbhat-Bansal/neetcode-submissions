class Solution {

    public String encode(List<String> strs) 
    {
        StringBuilder s = new StringBuilder();

        for (String str : strs) 
        {
            s.append(str.length()).append("#").append(str);
        }

        return s.toString();
    }

    public List<String> decode(String str) 
    {
        List<String> strs = new ArrayList<>();

        int i = 0;

        while (i < str.length()) 
        {
            int j = i;
            while (str.charAt(j) != '#') 
            {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            int start = j + 1;
            strs.add(str.substring(start, start + len));

            i = start + len;
        }

        return strs;
    }
}
