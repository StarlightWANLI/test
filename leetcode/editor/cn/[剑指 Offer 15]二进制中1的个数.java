//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

    //n表示二进制，输入必须是长度为 32 的 二进制串
    // n>>1：移位操作，删除n二进制的最右一位。
    //位运算，n&1：与操作，判断 n 二进制最右一位是否为 1
    final int BITS = 32;
    int ones = 0;
    for (int i = 0; i < BITS; i++) {
        ones += (n >> i) & 1;
    }
    return ones;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
