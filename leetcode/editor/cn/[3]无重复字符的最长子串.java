import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //最长无重复的字串问题，采用双指针滑动窗口
        if(s.length() == 0) return 0;
        //采用map既保存字符，又保存字符的位置
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //双指针，实现滑动窗口，只需要遍历一次
        int left = 0;
        int max = 0;
        //这里i相当于右指针right，每次移动一位
        for(int i =0; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                //出现重复，则左指针从最近的重复字符的下一个位置继续滑动
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //每次都要更新成最新的字符位置
            map.put(s.charAt(i),i);

            //每移动一次，求一次最大值
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
