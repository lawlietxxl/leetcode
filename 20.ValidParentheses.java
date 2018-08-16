// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

//这套最简单的解决方案结果是 44%
class Solution {
    public boolean isValid(String s) {
        Stack<Character> sc = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c == '[' || c== '{')
                sc.push(c);
            else if(c==')')
                if(sc.empty())
                    return false;
                else if(sc.peek()=='(')
                    sc.pop();
                else
                    return false;
            else if(c==']')
                if(sc.empty())
                    return false;
                else if(sc.peek()=='[')
                    sc.pop();
                else
                    return false;
            else if(c=='}')
                if(sc.empty())
                    return false;
                else if(sc.peek()=='{')
                    sc.pop();
                else
                    return false;
        }
        if(sc.empty())
            return true;
        else
            return false;
    }
}