//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //结果数组
    int[] res;
    //长度为n的整数的个数
    int count = 0;

    public int[] printNumbers(int n) {
        //大数采用字符串保存并打印的问题：
        //1、为了避免数字开头出现0，先把首位first固定，first取值范围为1~9
        //2、用digit表示要生成的数字的位数，本题要从1位数一直生成到n位数，对每种数字的位数都生成一下首位，所以有个双重for循环
        //3、生成首位之后进入递归生成剩下的digit - 1位数，从0~9中取值
        //4、递归的中止条件为已经生成了digit位的数字，即index == digit，将此时的数num转为int加到结果res中

        //1、1位内的整数有9个，1~9，2位内的整数有99，1~99，3位内的整数有（10*10*10-1）个，首位不能为0，只能取1~9，其他位可以取0~9
        res = new int[(int)Math.pow(10,n) - 1];

        //2、数字的长度digit最少为1,最大为n
        for (int digit = 1; digit < n + 1; digit++) {
            for (char first = '1'; first <= '9' ; first++) {
                //3、用长度为digit的数组保存结果
                char[] num = new char[digit];
                //4、存放首位
                num[0] = first;
                //5、从index为1开始填充数组
                dfs(1,num,digit);
            }
        }
        //System.out.println(count);
        return res;
    }


    /**
     * 填充数组
     * @param index   数组索引其实位
     * @param num     数字对应的字符数组
     * @param digit   数字长度
     */
    private void dfs(int index,char[] num,int digit){
        //数组index和数字最大长度digit相等时，结束循环。说明填充完了长度为digit的的数字
        if(index == digit){
            //注意char[] num数组转为数值int的方法
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }

        //由于首位已经填充了num[0]中的值，剩余分别用0~9字符填充
        for (char i = '0'; i <= '9'; i++) {
            num[index] = i;
            dfs(index + 1,num,digit);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
