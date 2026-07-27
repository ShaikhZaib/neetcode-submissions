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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty())
        {
            TreeNode rightSide = null;
            int qLen = q.size();

            for (int i = 0; i < qLen; i++)
            {
                TreeNode node = q.poll();
                rightSide = node;

                if (rightSide.left != null) q.offer(rightSide.left);
                if (rightSide.right != null) q.offer(rightSide.right); 
            }

            res.add(rightSide.val);
        } 

        return res;
    } 
    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
}
