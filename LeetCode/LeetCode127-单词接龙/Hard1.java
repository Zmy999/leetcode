package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hard1 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// 本身也算在转换序列中，初值设为1
		int res = 1;
		Queue<String> queue = new LinkedList<String>();
		// 将字典转换到HashMap中，应对后面字典中词量过大，查找太耗时
		// value默认为1，表示存在该词，为0则表示该词已被删除。
		HashMap<String, Integer> dict = new HashMap<>();
		for (String s : wordList) { // 将字典中的每一个词放入map中
			dict.put(s, 1);
		}
		// 队列每一层以","分隔（每一层指当前单词变换一个字符后所能得到的所有单词）
		queue.offer(beginWord);
		queue.offer(",");
		while (!queue.isEmpty()) {
			String wordString = queue.poll();
			// 便于以后修改当前word，查看字典中是否有满足此修改的单词
			StringBuilder word = new StringBuilder(wordString);
			// 仍处在当前层中
			if (!wordString.equals(",")) {
				// 二重循环，将每个单词的每个字符都在a~z置换一次，查找是否单词表中存在该词
				for (int i = 0; i < word.length(); i++) {
					char tmp = word.charAt(i);
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == word.charAt(i)) {		
							continue;		//与原单词字母相同则不替换，节省一步操作
						}
						//替换单词
						word.setCharAt(i, c);
						// 查找字典，看字典中是否有这个单词
						if (dict.getOrDefault(word.toString(), 0) != 0) {
							// 单词表中存在该词，加入到队列中，同时从单词表中删去改词，避免 hit->hot->hit此类情况。
							queue.offer(word.toString());
							dict.put(word.toString(), 0);
							// 如果当前词和endWord 相同，输出
							if (word.toString().equals(endWord)) {
								return res + 1;
							}
						}
					}
					//当前位置挨个替换后再还原为原单词，便于下一个字母的替换
					word.setCharAt(i, tmp);
				}
			} 
			// 上一层处理完，要处理下一层
			else if (!queue.isEmpty()) {
				queue.offer(",");
				res++;
			}
		}
		// 啥也没，返回0
		return 0;
	}
}
