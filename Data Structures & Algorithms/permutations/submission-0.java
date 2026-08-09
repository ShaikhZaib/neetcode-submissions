class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int idx)
    {
        // Handle base case 
        if (idx == nums.length)
        {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            res.add(perm);
            return;
        }

        // Loop through all possiblities
        for (int i = idx; i < nums.length; i++)
        {
            swap(nums, idx, i);
            backtrack(res, nums, idx + 1);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // Time Complexity -> O(n! * n)
    // Space Complexity -> O(n! * n) for output array
}
