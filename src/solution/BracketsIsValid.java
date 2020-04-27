package solution;

import java.util.Stack;

public class BracketsIsValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (!stack.isEmpty()) {
                if ((ch == ')' && stack.peek() == '(')
                        || (ch == ']' && stack.peek() == '[')
                        || (ch == '}' && stack.peek() == '{')) {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        BracketsIsValid bracketsIsValid = new BracketsIsValid();
        String str = "()[]{}";
        boolean result = bracketsIsValid.isValid(str);
        System.out.println(result);
    }
}
