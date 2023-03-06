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
    public ListNode deleteNode(ListNode head, int val) {
        //删除链表中指定的值分为2步:定位节点、修改引用
        //1、定位节点： 遍历链表，直到 head.val == val 时跳出，即可定位目标节点。
        //2、修改引用： 设节点 cur 的前驱节点为 pre ，后继节点为 cur.next ；则执行 pre.next = cur.next ，即可实现删除 cur 节点。

        //链表的很多问题，都可以用双指针来解决
        if(head.val == val){
            return head.next;
        }

        //双指针：pre记录上一个节点，cur记录当前节点
        ListNode pre = head,cur = head.next;
        while (cur != null && cur.val != val ){
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            //cur是要删除的目标节点，pre.next指向cur.next
            pre.next = cur.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
