package math;

public class Middle3 {
	public static int titleToNumber(String s) {	
		 int num = 0;
		 for(int i = 0;i < s.length();i++) {
			 num *= 26;							
			 num += trans(s.charAt(i));
		 }
		 return num;
	}
	public static int trans(char ch){	//26进制转10进制
        return ch - 'A' + 1;
    }
	public static void main(String[] args) {
		String s = "AB";
		System.out.println(titleToNumber(s));
	}
	
}
