class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Initialize res and cur
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        // sort the array 
        Arrays.sort(candidates);

        // call backtrack
        backtrack(res, cur, candidates, target, 0);

        // return res
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int target, int i)
    {
        // handle if cur is equal to target
        if (target == 0)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        // handle loop ending conditions
        if (i >= nums.length || target < 0)
        {
            return;
        }

        // implement take it branch 
        cur.add(nums[i]);
        backtrack(res, cur, nums, target - nums[i], i + 1);
        cur.remove(cur.size() - 1);

        // skip the duplicates numbers
        while (i + 1 < nums.length && nums[i] == nums[i + 1])
        {
            i++;
        }

        // implement leave it branch 
        backtrack(res, cur, nums, target, i + 1);
    }
    // Time Complexity -> O(n * 2 raise to n)
    // Space Complexity -> O(n)
}
