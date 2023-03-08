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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1、迭代方法：遍历节点，依次比较大小后，添加到新的链表后面
        /*ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1!=null &&  l2!=null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //合并l1、l2剩余的值
        prev.next = l1 == null ? l2 : l1;
        return  prehead.next;*/


        //2、递归方法
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
