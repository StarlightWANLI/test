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
    //获取链表中倒数第K个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        //由于不知道链表的长度，所以不知道从前往后，移动多少步
        //借用双指针，提前构建K个间距，然后2个指针一起移动，当前指针为空时，所以后指针距尾部k

        ListNode former = head,latter = head;
        //构建快慢指针的间距
        for (int i = 0; i < k; i++) {
            former = former.next;
        }

        //前节点为空，结束循环，此时后节点距尾部K
        while (former!=null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
