//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        //求最大水量的2个水柱:采用双指针算法
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j ){
            res =Math.max((j - i) * Math.min(height[i],height[j]),res);
            //小的往中间移一位
            if(height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
