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
    public boolean isPalindrome(ListNode head) {
        //1.用集合存储链表数据
        List<Integer> list = new ArrayList<>();
        ListNode currenNode = head;
        while (currenNode != null){
            list.add(currenNode.val);
            currenNode = currenNode.next;
        }
        //2.采用双指针判断是否回文
        int left = 0;
        int right = list.size() -1;
        while (left < right){
            if(!list.get(left).equals(list.get(right))){
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
