//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //求字符串的公共前缀
    public String longestCommonPrefix(String[] strs) {
        //遍历每一个字符串
        for (int i = 1; i < strs.length; i++) {
            //strs[0] 表示公共前缀
            int j = strs[0].length();
            //如果不满足公共前缀，则strs[0] 表示的公共前缀长度减1，继续匹配，直到找到公共前缀
            while (!strs[i].startsWith(strs[0])) {
                strs[0] = strs[0].substring(0, j--);
            }
        }
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
