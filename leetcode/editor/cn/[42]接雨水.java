//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //采用动态规划，求出每个位置到左右位置的最大高度
        int n = height.length;
        if(n == 0){
            return 0;
        }

        //每个节点到左侧的最大高度
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        //每个节点到右侧的最大高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        //遍历左右取小值，乘以高度
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
