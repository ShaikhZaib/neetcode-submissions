class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, currSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for(int num : nums){
            currSum += num;
            int diff = currSum - k;
            res += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
}