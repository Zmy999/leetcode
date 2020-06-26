package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Middle2 {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		makeStr(list, "", 0, 0, n);
		return list;
	}
	public void makeStr(List<String> list, String str, int open, int close, int n) {
		if(close == n) {					// 若")"数达n，说明"("和")"数均已达到n个
			list.add(str);
		}
		else {					
			if (open < n) {					// 若"("未达最大数n则可以加一个"("
				makeStr(list, str + "(", open + 1, close, n);
			}
			if (close < open) {				// 若")"数小于"("数，则可以加一个")"
				makeStr(list, str + ")", open, close + 1, n);
			}
		}
	}
}
