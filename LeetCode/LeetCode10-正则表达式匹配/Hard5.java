package backtracking;

public class Hard5 {
	public boolean isMatch(String s, String p) {
		// 如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
		if (p.isEmpty())
			return s.isEmpty();
		// 判断s和p的首字符是否匹配，注意要先判断s不为空
		boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		// 如果p的第一个元素的下一个元素是*
		if (p.length() >= 2 && p.charAt(1) == '*') {	
			// 则分别对两种情况进行判断
			//情况1：s：bc，p：a*bc，调用isMatch(s:bc,p:bc)，即保持s不变，截取p
			//情况2：s：aabb，p：a*bb，调用isMatch(s:abb,p:a*bb)，即保持p不变，减掉s的首元素
			return isMatch(s, p.substring(2)) || (headMatched && isMatch(s.substring(1), p));
		} 
		// 否则，如果s和p的首字符匹配，则截取后继续比较下一个，直到出现.或*或不匹配
		else if (headMatched) {
			return isMatch(s.substring(1), p.substring(1));
		} 
		//不匹配则返回false
		else {	
			return false;
		}
	}
}
