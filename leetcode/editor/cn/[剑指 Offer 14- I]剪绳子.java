//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        //求最大值得问题，典型得动态规划求解
        //前提：2 <= n <= 58，所以用int存储结果就够了

        //假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
        //将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
        //将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。

        //最大值    dp[i]max = Max(j×(i−j),j×dp[i−j]);

        //假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i）,动态规划一般先求小值后续得循环才能利用之前求解的值
        //由于长度可以取到n，所以这里的初始化数组大小为 n + 1
        int dp[] = new int[n + 1];

        //i表示绳子的长度,由于n>1,所以这里i从2开始遍历
        for (int i = 2; i <= n; i++) {
            //j表示拆出的第一个正整数
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                //当前裁剪方法的最大值
                int tempMax = Math.max(j * (i-j),j * dp[i - j]);
                //和已知的最大值做比较
                curMax = Math.max(curMax,tempMax);
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
