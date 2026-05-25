class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> m = new HashMap<>();

        for(String s : strs)
        {
            char[] ch = s.toCharArray();

            Arrays.sort(ch);

            String key = new String(ch);

            if(!m.containsKey(key))
            {
                m.put(key, new ArrayList<>());
            }

            m.get(key).add(s);
        }

        return new ArrayList<>(m.values());
    }
}