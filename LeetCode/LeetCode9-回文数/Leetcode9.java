package leetcode;

public class Leetcode9 {
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		String s = String.valueOf(x);
		int p = s.length()-1;
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(i) != s.charAt(p))
				return false;
			p--;
		}
		return true;
    }
}
