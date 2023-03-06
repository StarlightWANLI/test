//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //判断回文字符串，采用双指针，左右指针一直相等就是回文字符串
        //注意字符串相关的几个函数：s.length(),s.charAt(),Character.isLetterOrDigit(),Character.toLowerCase()
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                  left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left < right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                     return false;
                }else{
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
