//leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom {
    //考场座位：每次落座取离其他有人的座位最远的最小编号的座位

    //有序集合：记录间隔距离
    private TreeSet<int[]> ts = new TreeSet<>((a,b) ->{
        int d1 = dist(a),d2 = dist(b);
        return d1 == d2 ? a[0] - b[0] : d2 - d1;
    });

    //计算数组距离
    private int dist(int[] s){
        int l = s[0], r = s[1];
        //>>1  等价于 /2
        //<<1  等价于 *2
        return l == -1 || r == n ? r - l - 1 : (r - l) >> 1;
    }


    //维护每个有学生的座位的左右邻居学生
    private Map<Integer,Integer> left = new HashMap<>();
    private Map<Integer,Integer> right = new HashMap<>();
    private int n;

    public ExamRoom(int n) {
        //初始n个座位
        this.n = n;
        add(new int[]{-1,n});
    }

    //增加新的段，并记录左右相邻的位置
    private void add(int[] s) {
        ts.add(s);
        left.put(s[1], s[0]);
        right.put(s[0], s[1]);
    }
    //删除段
    private void del(int[] s) {
        ts.remove(s);
        left.remove(s[1]);
        right.remove(s[0]);
    }

    //选择考试座位
    public int seat() {
        //先选择间隔最大的段
        int[] s = ts.first();
        //计算中位p
        int p = (s[0] + s[1]) >> 1;
        if (s[0] == -1) {
            p = 0;
        }else if(s[1] == n){
            p = n - 1;
        }
        //删除最大的段
        del(s);
        add(new int[]{s[0],p});
        add(new int[]{p,s[1]});
        return p;
    }

    //离开座位：注意要合并段
    public void leave(int p) {
        int l = left.get(p),r = right.get(p);
        del(new int[]{l,p});
        del(new int[]{p,r});
        //合并段
        add(new int[]{l,r});
    }

}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)
