//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        //当在第n-1个阶梯时，只能跳1个台阶，跳法已经固定，不能算新的跳法，前面n-1阶的跳法为:dp[n-1]
        //当在第n-2个阶梯时，可以跳2个台阶，跳法也已经固定，要么跳2格，要么跳2次1格，不能算新的跳法，前面n-2阶的跳法为:dp[n-2]
        //由于跳到第n-1个阶梯的跳法和跳到第n-2个阶梯的跳法不可能重复，所以得出状态转移方程
        //状态转移方程：dp[n] = dp[n -1] + dp[n -2]
        /*int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if(i == 0){
                dp[i] = 1;
            }else if(i == 1){
                dp[i] = 1;
            }else{
                dp[i] = (dp[i -1] + dp[i -2])%1000000007;
            }
        }
        return dp[n];*/


        //内存优化
        int a=0,b=0,sum=0;
        for (int i = 0; i <= n; i++) {
            if(i == 0){
                 a = 1;
                 sum = 1;
            }else if(i == 1){
                 b = 1;
                 sum = 1;
            }else{
                sum = (a + b) % 1000000007;

                a = b;
                b = sum;
            }
        }
        return  sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
