package math;

public class Primary5 {
	public static int hammingDistance(int x, int y) {
		int count = 0;
		int xor=x^y;		//异或
		while(xor != 0) {
			xor=xor&(xor-1);
            count++;
		}
		return count;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingDistance(15,2));
	}
}
