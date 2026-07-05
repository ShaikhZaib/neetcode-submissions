class Solution {
    public int longestConsecutive(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       int res = 0;

       for(int num : nums){
        if(!map.containsKey(num)){
            int length = map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1;
            int prevBoundry = num - map.getOrDefault(num - 1, 0);
            int nextBoundry = num + map.getOrDefault(num + 1, 0);

            map.put(num, length);
            map.put(prevBoundry, map.get(num));
            map.put(nextBoundry, map.get(num));

            res = Math.max(res, map.get(num));
        } 
       } 

       return res; 
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
}
