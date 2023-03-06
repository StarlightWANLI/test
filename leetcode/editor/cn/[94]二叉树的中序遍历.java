//leetcode submit region begin(Prohibit modification and deletion)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        this.inorder(root,res);
        return res;
    }


    public void inorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        this.inorder(root.left,res);
        res.add(root.val);
        this.inorder(root.right,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
