package math;

import java.util.Stack;

public class Primary6 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();	//栈中只有右括号
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '[')
				stack.push(']');
			else if (c == '{')
				stack.push('}');
			//当遇到不是左括号的时候，就判断这个括号是否和刚进栈的字符一样
			else if(stack.isEmpty()||stack.pop() != c)
                return false;
		}
		return stack.isEmpty();		//为空则全匹配
	}

	public static void main(String[] args) {

	}
}
