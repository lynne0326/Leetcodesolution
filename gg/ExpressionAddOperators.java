import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 18/8/23.
 */
public class ExpressionAddOperators {
    //1. 用long来避免溢出
    //2. 处理 乘* 的时候要特别注意,所以一定要记录前一个prev, 先减去前一个数再+乘前一个数
    //3. 传prev的时候要加上符号
    //4. 遇到以0开头的数字时候,除了0单独出现要dfs, 只dfs这次,后面的就不valid了,要跳出loop,也就是return
    //   比如遇到 105, 1*0*5 都是valid的 但是 1* 05 就不算.所以一定要最后再判断 if(n == 0 && i == idx)
    // 复杂度大概是 o(4^(n-1)) 插入n-1个operator,每个有+-*''(combine two character)
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, 0, (long)target, 0l, "", res, 0l);
        return res;
    }

    private void helper(String num, int idx, long target, long cur, String s, List<String> res, long prev) {
        if(idx == num.length() && cur == target) {
            res.add(s.substring(1));
            return;
        }

        long n = 0;
        for (int i = idx; i < num.length(); i++) {
            n = n * 10 + (num.charAt(i) - '0');
            helper(num, i + 1, target, cur + n, s + "+" + n, res, n);
            if(idx != 0) {
                helper(num, i + 1, target, cur - n, s + "-" + n, res, -n);
                helper(num, i + 1, target, cur - prev + prev * n, s + "*" + n, res, prev*n);
            }
            if(n == 0 && i == idx) return;
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        expressionAddOperators.addOperators("123", 6);
    }
}
