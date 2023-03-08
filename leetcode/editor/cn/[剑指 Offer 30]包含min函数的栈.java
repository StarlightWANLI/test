//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        //用空间换时间，采用额外的栈结构，保存每个元素对应的栈的最小值
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    //向栈中存放元素
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    //弹出
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    //获取顶部元素
    public int top() {
       return xStack.peek();
    }

    //获取当前栈的最小值
    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
