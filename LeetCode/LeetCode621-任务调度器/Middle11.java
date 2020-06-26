package math;

import java.util.Arrays;

public class Middle11 {
	public static int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for(int i = 0;i < tasks.length;i++) {
			count[tasks[i]-'A']++;		//统计词频
		}
		Arrays.sort(count);				//词频排序，升序排序，count[25]是频率最高的
		int maxCount = 0;
		for(int i = 25;i > 0;i--) {		//统计有多少个频率最高的字母
			if(count[i] != count[25]){
                break;
            }
			maxCount++;
		}
		return Math.max((count[25] - 1) * (n + 1) + maxCount , tasks.length);
    }
}
