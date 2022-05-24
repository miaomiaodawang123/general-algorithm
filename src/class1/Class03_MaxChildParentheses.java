package class1;

public class Class03_MaxChildParentheses {

    public static int getMaxLength(String s){
        if (s == null || "".equals(s)){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        //dp数组，dp[i]表示0~i位置 合法字符串的最大长度
        int[] dp = new int[N];
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ')'){
                //找到当前位置上一个位置合法字符起始位置的前一个位置
                int pre = i - dp[i - 1] - 1;
                // 如果这个位置是(,就说明，当前位置的合法字符数量至少等于上一个位置数量+2
                if (pre >= 0 && str[pre] == '('){
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = getMaxLength("(()))))(((())))");
        System.out.println(i);
    }
}
