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
    public int maxDepth(TreeNode root) {
        return recursive(root);
    }

    public int recursive(TreeNode current) {
        if (current == null) return 0;
        int d1 = 1 + recursive(current.left);
        int d2 = 1 + recursive(current.right);
        if (d1 > d2) return d1;
        else return d2;
    }
}
