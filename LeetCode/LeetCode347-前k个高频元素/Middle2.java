package sortandsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Middle2 {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {					//统计每个数出现的频次
			if (!map.containsKey(num)) {		//第一次出现的数作为key存入map
				map.put(num, 1);
			} else {							//否则次数加1
				map.put(num, map.get(num) + 1);
			}
		}
		// 桶排序
		List<Integer>[] bucket = new ArrayList[nums.length + 1];	//初始化桶，将key对应的出现频次放入桶中
		// 将每个数插入索引为它的频次的那个桶里，例如1出现了3次，则buckets[3] = 1;
		for (Integer key : map.keySet()) {							//遍历所有key值
			int freq = map.get(key);								//取该key值对应的频率
			if (bucket[freq] == null) {								//未出现的数字置空处理
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}
		List<Integer> res = new ArrayList<>();						//最终结果	
		for (int i = nums.length; i >= 0 && res.size() < k; --i) {	// 越在数组后面的频次就越高，只需要倒着遍历桶即可
			if (bucket[i] != null) {
				res.addAll(bucket[i]);								//添加入res
			}
		}
		int[] ans = res.stream().mapToInt(Integer::valueOf).toArray();		//转数组
		return ans;
	}
}	
