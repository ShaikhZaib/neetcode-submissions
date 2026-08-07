class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target)
    {
        // Initialize
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, target, res, cur, 0);
        return res;
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int i)
    {
        // Handle base case for adding a element
        if (target == 0)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        // Handle base cases for ending the loop
        if (target < 0 || i >= nums.length)
        {
            return;
        }

        // Add the num
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], res, cur, i);

        // Remove the num
        cur.remove(cur.size() - 1);
        backtrack(nums, target, res, cur, i + 1);
    }
    // Time Complexity -> O(2 raise to t/m)
    // Space Complexity -> O(t/m)
}
