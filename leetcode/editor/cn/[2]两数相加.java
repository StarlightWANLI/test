//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //用倒序链表计算两数之和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //使用pre节点，防止head指针丢失
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;

        while (l1 != null || l2 != null){
              //为空的话，用0补齐
              int x = l1 == null ? 0 : l1.val;
              int y = l2 == null ? 0 : l2.val;

              int sum = x + y + carry;

              //进位
              carry = sum / 10;
              //剩余
              sum = sum % 10;
              cur.next = new ListNode(sum);

              cur = cur.next;
              if(l1 != null){
                  l1 = l1.next;
              }
              if(l2 != null){
                  l2 = l2.next;
              }
        }
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return  pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
