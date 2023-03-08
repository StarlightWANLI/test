//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //左、上、右、下四个边界，模拟以上矩阵遍历顺序。

        if(matrix.length == 0) return new int[0];

        //l左边界，r右边界，t上边界，b下边界，注意4个方向的边界值逐渐向内变化      x表示返回数组的初始位置
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;

        //声明需要返回结果数组
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            // 从左到右，
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break;

            //从上往下
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;

            //从右往左
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;

            //从下往上
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
