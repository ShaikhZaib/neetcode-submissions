class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            int[] count = new int[26];
            for(char c : word.toCharArray()){
               count[c - 'a']++; 
            }

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    // Time Complexity -> O(m * n)
    // Space Complexity -> O(m * n)
}
