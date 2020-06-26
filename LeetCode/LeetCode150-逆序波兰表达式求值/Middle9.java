package math;

import java.util.Stack;

public class Middle9 {
	public int evalRPN(String[] tokens) { 			
		String str1, str2;							//定义操作数
		int num1, num2;								//字符串类型操作数转换为整型
		int temp;									//保存临时计算结果
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < tokens.length; i++) {
			if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
				stack.push(tokens[i]);					//若为数字，则存入栈中
			}
			else {										//若为操作符，则出栈两个数字进行计算
				str2 = stack.pop();
				str1 = stack.pop();
				num2 = Integer.parseInt(str2);
				num1 = Integer.parseInt(str1);
				if(tokens[i].equals("+")) { 			//进行相应计算
					temp = num1 + num2;
					 
				}
				else if(tokens[i].equals("-")) {
					temp = num1 - num2;
				 
				}
				else if(tokens[i].equals("*")) {
					temp = num1 * num2;
				 
				}
				else {
					temp = num1 / num2; 
				}
				stack.push(String.valueOf(temp));	//将计算的中间结果转为字符串存入栈中
			}
		}
		return Integer.parseInt(stack.peek());		//栈顶即为计算结果，转为整型返回
	}
}
