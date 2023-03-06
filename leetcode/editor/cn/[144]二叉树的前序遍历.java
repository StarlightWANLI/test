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
    public List<Integer> preorderTraversal(TreeNode root) {
        //采用非递归方式实现前序遍历
        List<Integer> res = new ArrayList<Integer>();
        if(root ==  null){
            return res;
        }
        //java官方文档推荐用deque实现栈（stack）。
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while(node != null){
                //前序遍历，先访问根节点
                res.add(node.val);

                stack.push(node);
                //继续遍历下一个左节点
                node = node.left;
            }
            //FIFO倒序遍历每个节点的右节点
            node = stack.pop();
            node = node.right;
        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
