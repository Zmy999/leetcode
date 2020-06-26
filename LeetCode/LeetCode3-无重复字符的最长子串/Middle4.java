package array;

public class Middle4 {
	public static int lengthOfLongestSubstring(String s) {		//滑块思想
		 int hash[] = new int [500];
		 int max = 0;
		 int i = 0,j = 0;										//设置快指针j，慢指针i
		 while(i < s.length() && j < s.length()) {
			 if(hash[s.charAt(j)] == 0) {						//不重复，更新max
				 hash[s.charAt(j)] = 1;
				 j++;
				 max = (j - i) > max ? (j - i) : max;
			 }
			 else {												//重复，慢指针i后移
	                hash[s.charAt(i)] = 0;
	                i++;
	         }  
		 }
		 return max;
	}
}
