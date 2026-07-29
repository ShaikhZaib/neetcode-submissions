/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] idx = new int[2];
        return dfs(preorder, inorder, Integer.MAX_VALUE, idx);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit, int[] idx)
    {
        if (idx[0] >= preorder.length) return null;

        if (inorder[idx[1]] == limit) 
        {
            idx[1]++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = dfs(preorder, inorder, root.val, idx);
        root.right = dfs(preorder, inorder, limit, idx);

        return root;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
}
