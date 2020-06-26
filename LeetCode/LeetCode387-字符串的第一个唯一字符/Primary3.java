package string;

public class Primary3 {
	public int firstUniqChar(String s) {
		char chars[] = s.toCharArray();
		int count = 0;
		for(int i = 0;i < chars.length;i++) {
			for(int j = 0;j < chars.length;j++) {
				if(i!=j) {
					if (chars[i] == chars[j]) {
						count = -1;
						break;
					}
					else {
						count = i;
					}
				}
			}
			if(count == i)				//如果相等  说明没有相同的
            {
                return count;
            }
		}
		if (s.equals("")) {
            return -1;
        }
		return count;
    }
}
