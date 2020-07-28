package leetcode;
public class Leetcode389 {
	public char findTheDifference(String s, String t) {
		int[] record = new int[26];
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < lenS; i++){
            record[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < lenT; i++){
            record[t.charAt(i) - 'a'] -= 1;
            if (record[t.charAt(i) - 'a'] < 0) 
            	return t.charAt(i);
        }
        return ' ';
    }
}
