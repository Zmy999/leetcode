package string;

public class Primary9 {
	public String countAndSay(int n) {
		String res = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder temp = new StringBuilder();
			char ch = res.charAt(0);
			int cnt = 1;
			for (int j = 1; j < res.length(); j++) {
				char tempCh = res.charAt(j);
				//检查前一个与当前是否相同，相同则加1
				if(ch == tempCh) {
					//计数增加后继续遍历
					cnt++;	
				}
				else {
					temp.append(cnt).append(ch);
					//重新计数
					cnt = 1;
					//当前指针后移
                    ch = tempCh;
				}
			}
			temp.append(cnt).append(ch);
            res = temp.toString();
		}
		return res;
	}
}
