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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursive(p, q);
    }

    public boolean recursive(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (!(a == null) == (b == null)) return false;
        if (a.val != b.val) return false;
        if (!(a.left == null) == (b.left==null)) return false;
        if (!(a.right == null) == (b.right==null)) return false;
        boolean b1 = recursive(a.left, b.left);
        boolean b2 = recursive(a.right, b.right);
        return (b1 && b2);
    }
}
