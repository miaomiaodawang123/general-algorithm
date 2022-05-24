package class1;

public class Class02_Parentheses {

    //1.判断是否是合法的
    public static boolean isValid(String str){
        if (str == null || "".equals(str)){
            return false;
        }
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '('){
                count ++;
            }else if (aChar == ')'){
                count --;
            }
            if (count < 0){
                return false;
            }
        }
        return count == 0;
    }
    //不合法的需要补几个字符
    public static int needParentheses(String str){
        if (str == null || "".equals(str)){
            return -1;
        }
        char[] chars = str.toCharArray();
        int count = 0;
        int need = 0;
        for (char aChar : chars) {
            if (aChar == '('){
                count ++;
            }else if (aChar == ')'){
                count --;
            }
            if (count == -1){
                need ++;
                count = 0;
            }
        }
        return need + count;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("())"));
        System.out.println(isValid("())("));
        System.out.println(isValid("(())"));
        System.out.println(isValid("("));

        System.out.println(needParentheses("()"));
        System.out.println(needParentheses("())"));
        System.out.println(needParentheses("())("));
        System.out.println(needParentheses("(())"));
        System.out.println(needParentheses("("));
    }
}
