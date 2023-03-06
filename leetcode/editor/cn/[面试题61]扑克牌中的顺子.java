//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        //5张牌是否是顺子：
        //1、除大小王外，不能重复，也就是只有0可用重复，最多可用出现2个0
        //2、max - min < 5

        //遍历数组，利用Set集合进行判重，并获取最大值，最小值
        Set<Integer> repeat = new HashSet<Integer>();
        int min = 0, max = 14;

        for (int i = 0; i < nums.length; i++) {
            // 跳过大小王
            if(nums[i] == 0) continue;

            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);

            if(repeat.contains(nums[i])){
                return false;
            }else{
                repeat.add(nums[i]);
            }
        }
        return max - min < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
