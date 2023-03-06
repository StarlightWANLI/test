//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        //Java中因为n的最小值可以取到Integer.MIN_VALUE，如果直接取它的相反数的话还是它自己，会导致堆栈溢出，因此提一个x出来，具体看代码
        if(n == 0){
             return 1;
        }else if(n < 0){
            return 1/(x * myPow(x,-n-1));
        }else if(n % 2 ==1){
            return x * myPow(x,n-1);
        }else{
            return  myPow(x * x,n/2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
