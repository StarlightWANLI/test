//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        //表示数值的字符串
        //首先要需要满足的条件，然后采用有限状态自动机来逐步进行状态转移判定

        //1、首先定义状态转移
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        //初始状态 ——> 有4种转移状态
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            //如果下一个字符是空格，还是初始状态
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            //是数字，转移为整数状态
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            //小数点，转移为左侧没有整数的小数点状态
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            //符号，转移为整数符号状态
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);

        //整数部分符号状态，有2种状态转移
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            //整数，则转移为整数状态 ,比如+1
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            //小数点，则转移为左侧没有整数的小数点状态，比如 +.
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);


        //整数状态有4种状态转移
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            //数字，仍然是整数状态
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            //字符 e，转移为字符e状态
            put(CharType.CHAR_EXP, State.STATE_EXP);
            //小数点，转移为小数点状态
            put(CharType.CHAR_POINT, State.STATE_POINT);
            //空格，转移为末尾空格状态
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);


        //小数点状态有3种状态转移
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            //数字，转移为小数部分状态
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            //字符e，转移为字符e状态
            put(CharType.CHAR_EXP, State.STATE_EXP);
            //空格，转移末尾空格状态
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);

        //左侧没有整数部分的小数点状态  只有1种转移状态
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            //数字，转移为小数状态
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        //小数状态有3种状态转移
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            //数字，仍然是小数状态
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            //字符e，转移为字符e状态
            put(CharType.CHAR_EXP, State.STATE_EXP);
            //空格，转移为末尾空格状态
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);


        //字符e状态有2种转移状态
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            //数字，转移为字符e数字状态   12e6
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            //符号，转移为字符e符号状态   12e+
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);


        //字符e符号状态，有1种状态转移
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            //数字，转移为字符e数字状态
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        //字符e数字状态，有2种状态转移
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            //数字，转移为字符e数字状态
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            //空格，转移为结束状态
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        //结束状态只有1种状态转移
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            //空格，仍然是结束状态
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);


            int length = s.length();
            //初始状态
            State state = State.STATE_INITIAL;

            for (int i = 0; i < length; i++) {
                CharType type = toCharType(s.charAt(i));
                if (!transfer.get(state).containsKey(type)) {//状态是否存在对应的状态转移
                    return false;
                } else {
                    //将状态转移为下一个状态
                    state = transfer.get(state).get(type);
                }
            }
            //最终的状态如果是整数状态、小数点状态"111."、小数状态、字符e数字状态、结尾状态，则认为是数字
            return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
        }

        //字符对应的字符类型
        public CharType toCharType(char ch) {
            if (ch >= '0' && ch <= '9') {
                return CharType.CHAR_NUMBER;
            } else if (ch == 'e' || ch == 'E') {
                return CharType.CHAR_EXP;
            } else if (ch == '.') {
                return CharType.CHAR_POINT;
            } else if (ch == '+' || ch == '-') {
                return CharType.CHAR_SIGN;
            } else if (ch == ' ') {
                return CharType.CHAR_SPACE;
            } else {
                return CharType.CHAR_ILLEGAL;
            }
        }

        //所有的状态
        enum State {
            //起始的空格
            STATE_INITIAL,
            //符号位
            STATE_INT_SIGN,
            //整数部分
            STATE_INTEGER,
            //左侧有整数的小数点
            STATE_POINT,
            //左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
            STATE_POINT_WITHOUT_INT,
            //小数部分
            STATE_FRACTION,
            //字符 e
            STATE_EXP,
            //数部分的符号位
            STATE_EXP_SIGN,
            //指数部分的整数部分
            STATE_EXP_NUMBER,
            //末尾的空格
            STATE_END
        }


        //符号类型
        enum CharType {
            //数字
            CHAR_NUMBER,
            //字符 e
            CHAR_EXP,
            //小数点
            CHAR_POINT,
            //符号
            CHAR_SIGN,
            //空格
            CHAR_SPACE,
            //非法字符
            CHAR_ILLEGAL
        }
}
//leetcode submit region end(Prohibit modification and deletion)
