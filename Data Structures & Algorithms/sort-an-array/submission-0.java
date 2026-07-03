class Solution {
    private void countingSort(int[] nums){
        HashMap<Integer, Integer> count = new HashMap<>();
        int minVal = nums[0];
        int maxVal = nums[0];

        for(int num : nums){
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for(int val = minVal; val <= maxVal; val++){
            while(count.getOrDefault(val, 0) > 0){
                nums[index] = val;
                index++;
                count.put(val, count.getOrDefault(val, 0) - 1);
            }
        }
    }

    public int[] sortArray(int[] nums) {
        countingSort(nums);
        return nums;
    }

    // Time Complexity -> O(n + k)
    // Space Complexity -> O(n)
}