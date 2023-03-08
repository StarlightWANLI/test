//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //交换数组中数字的顺序，让奇数在前，偶数在后
    public int[] exchange(int[] nums) {
        //考虑定义双指针 i , j 分列数组左右两端，循环执行：
        //1、指针 i 从左向右寻找偶数；
        //2、指针 j 从右向左寻找奇数；
        //3、将 偶数 nums[i] 和 奇数 nums[j] 交换。
        //可始终保证： 指针 i 左边都是奇数，指针 j 右边都是偶数 。

        int left = 0,right = nums.length - 1,tmp;
        while (left < right){
            //从左往右，依次取偶数，(nums[left] & 1) == 1表示奇数
            while(left < right && (nums[left] & 1) == 1) left++;
            //从右往左，依次取奇数
            while(left < right && (nums[right] & 1) == 0) right--;

            //左右都取到值了，交换位置
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return  nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
