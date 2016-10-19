import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class SubList {

	public static void main(String[] args) {
		List<Integer> iList = null;
		iList = Lists.newArrayList();
		System.out.println(JSON.toJSONString(iList));
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 31; i++) {
			list.add(i);
			
		}
		int PAGE_SIZE = 30;
		int totalCount = list.size();
		int num = totalCount % PAGE_SIZE == 0 ? totalCount / PAGE_SIZE : totalCount / PAGE_SIZE + 1;
		for (int pageNum = 1; pageNum <= num; pageNum++) {
			int toIndex = pageNum * 30;
			if (toIndex > totalCount) {
				toIndex = totalCount;
			}
			
			List<Integer> dealList = list.subList((pageNum - 1) * PAGE_SIZE, toIndex);
			System.out.println("++++"+JSON.toJSONString(dealList));
//			int size = list.size();
//			int numOfEachThread = size / 2;
//			int mod = size % 2;
//			int numOfSomeThread = numOfEachThread + 1;
//			for (int i = 0; i < mod; i++) {
//				System.out.println(JSON.toJSONString(list.subList(i * numOfSomeThread, (i + 1) * numOfSomeThread)));
//			}
//			for (int i = mod; i < 2; i++) {
//				System.out.println(JSON.toJSONString(list.subList(i * numOfEachThread + mod, (i + 1) * numOfEachThread + mod)));
//			}
		}
	}
}
