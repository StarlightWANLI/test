//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        //剪绳子2中由于n的取值范围变了：2 <= n <= 1000，所以不能再采用动态规划了，会出现数值类型越位的情况
        //核心思想是采用贪心算法，每次尽量把绳子剪成长度为3的小段，这样乘积最大。

        //切分规则：如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段；每次乘法操作后记得取余就行
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            //每次减去长度为3
            n -= 3;
        }
        //最后剩余的长度，只会是4,3,2,1,直接和最后的结果相乘，取模
        return (int) (res * n % 1000000007);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
