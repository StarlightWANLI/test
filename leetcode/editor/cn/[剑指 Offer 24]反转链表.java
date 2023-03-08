//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //反转链表
    public ListNode reverseList(ListNode head) {
        //遍历链表，并在访问各节点时修改 next 引用指向

        ListNode cur = head,pre = null;

        while (cur != null){
            ListNode tmp = cur.next;

            //指针方向改变
            cur.next = pre;

            //前节点变更
            pre = cur;
            //当前节点变更
            cur = tmp;
        }
        return  pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
