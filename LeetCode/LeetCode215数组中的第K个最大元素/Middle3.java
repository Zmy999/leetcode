package sortandsearch;

import java.util.PriorityQueue;

public class Middle3 {
	public int findKthLargest(int[] nums, int k) {
		// 维护一个大小为k的优先队列，保证每次取出的元素都是队列中权值最小的
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.offer(num);
			if (queue.size() > k) 	// 
				queue.poll(); 		// 超过就出队，堆顶元素为当前最小，即为第K大
		}
		return queue.peek();
	}
}
