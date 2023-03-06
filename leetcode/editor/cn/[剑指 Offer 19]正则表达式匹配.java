//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        //由于存在*匹配多个的情况，所以可以采用动态规划

        //s是用来匹配的字符串，p是正则表达式
        int m = s.length();
        int n = p.length();

        //用来存放动态规划匹配的中间结果，当前位匹配上了，就可用根据之前位置的匹配情况看截止当前位置是否匹配
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //如果模板中出现*号，需要分别  拿*号前一位去匹配（即前一位）和 去掉前一位后去匹配(既前2位)
                if (p.charAt(j - 1) == '*') {
                    //去掉前一位后去匹配(既前2位)
                    f[i][j] = f[i][j - 2];
                    if(!f[i][j]){
                        //拿*号前一位去匹配（即前一位）
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] =  f[i - 1][j];
                        }
                    }
                } else {
                    //指定位上满足匹配条件，更新动态数组结果
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    /**
     * 字符串s的第i-1位和字符串p的j-1位比较，是否匹配
     * @param s
     * @param p
     * @param i  从1开始取值，charAt(i - 1)
     * @param j  从1开始取值，charAt(j - 1)
     * @return
     */
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
