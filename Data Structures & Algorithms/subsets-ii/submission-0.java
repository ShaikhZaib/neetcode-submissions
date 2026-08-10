class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        // Initialize list for res and subset
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        // Sort the nums array
        Arrays.sort(nums);

        // Call the backtrack
        backtrack(res, subset, nums, 0);

        // Return res
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int i)
    {
        // Handle base case
        if (i >= nums.length)
        {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Handle the branch where we include the number
        subset.add(nums[i]);
        backtrack(res, subset, nums, i + 1);
        subset.remove(subset.size() - 1);

        // Skip the duplicate number
        while (i + 1 < nums.length && nums[i] == nums[i + 1])
        {
            i++;
        }

        // Handle the branch where we don't include the number
        backtrack(res, subset, nums, i + 1);
    }
    // Time Complexity -> O(n * 2 raise to n)
    // Space Complexity -> O(n) extra space 
    //                     O(2 raise to n) output 
}
