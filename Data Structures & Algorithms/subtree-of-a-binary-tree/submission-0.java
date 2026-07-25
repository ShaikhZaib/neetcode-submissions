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
    private boolean sameTree(TreeNode root, TreeNode subRoot)
    {
        if (root == null && subRoot == null) return true;

        if (root == null || subRoot == null) return false;

        if (root.val != subRoot.val) return false;

        return sameTree(root.left, subRoot.left) &&
               sameTree(root.right, subRoot.right); 
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;

        if (root == null) return false;

        if (sameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot); 
    }
    // Time Complexity -> O(m * n)
    // Space Complexity -> O(m + n)
}
