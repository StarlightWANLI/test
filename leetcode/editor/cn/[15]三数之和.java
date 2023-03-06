//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //三数之和为0：如果要满足不重复，三元组 (a,b,c) 满足 a≤b≤c，保证了只有 (a,b,c) 这个顺序会被枚举到
        //所以需要先对数组进行排序，然后进行三重遍历
        //我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法

        //结论：排序 + 双指针
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //第一层遍历，枚举a的取值
        for (int first = 0; first < n; first++) {
            //不取重复值
            if(first > 0 && nums[first] == nums[first-1]){
               continue;
            }

            //双指针求的目标值
            int target = -nums[first];

            int third = n - 1;
            //枚举b
            for (int second = first + 1; second < n; second++) {
                //不取重复值
                if(second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }

                //由于数组经过了排序，第三个数需要从大到小取值
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }

                //第三个值不能和第二个值相等
                if(second == third){
                    break;
                }

                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }
        return  ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
