public class Heap {
	public void heap_sort(int[] arrays, int e) {
		if (e > 0) {
			init_sort(arrays, e);// 初始化堆，找出最大的放在堆顶
			// snp(arrays);
			arrays[0] = arrays[e] + arrays[0];
			arrays[e] = arrays[0] - arrays[e];
			arrays[0] = arrays[0] - arrays[e];
			// snp(arrays);
			heap_sort(arrays, e - 1);
		} else {
			snp(arrays);
		}
	}

	public void snp(int[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
		System.out.println();
	}

	public void init_sort(int[] arrays, int e) {
		int m = (e + 1) / 2;
		for (int i = 0; i < m; i++) {
			boolean flag = build_heap(arrays, e, i);
			// 如果孩子之间有交换，就要重新开始
			if (flag) {
				i = -1;
			}

		}

	}

	// 返回一个标记，如果有根与孩子交换就要重新从顶根开始查找不满足最大堆树结构
	public boolean build_heap(int arrays[], int e, int i) {
		int l_child = 2 * i + 1;// 左孩子
		int r_child = 2 * i + 2;// 右孩子
		if (r_child > e) { // 判断是否有右孩子，没有的话直接比较，小于交换
			if (arrays[i] < arrays[l_child]) {
				arrays[i] = arrays[i] + arrays[l_child];
				arrays[l_child] = arrays[i] - arrays[l_child];
				arrays[i] = arrays[i] - arrays[l_child];
				return true;
			} else {
				return false;
			}
		}
		// 在根与两个孩子之间找出最大的那个值进行交换
		if (arrays[i] < arrays[l_child]) {
			if (arrays[l_child] > arrays[r_child]) {
				// 交换根与左孩子的值
				arrays[i] = arrays[i] + arrays[l_child];
				arrays[l_child] = arrays[i] - arrays[l_child];
				arrays[i] = arrays[i] - arrays[l_child];
				return true;
			} else {
				// 交换根与右孩子的值
				arrays[i] = arrays[i] + arrays[r_child];
				arrays[r_child] = arrays[i] - arrays[r_child];
				arrays[i] = arrays[i] - arrays[r_child];
				return true;
			}
		} else if (arrays[i] < arrays[r_child]) {
			// 交换根与右孩子的值
			arrays[i] = arrays[i] + arrays[r_child];
			arrays[r_child] = arrays[i] - arrays[r_child];
			arrays[i] = arrays[i] - arrays[r_child];
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		Heap h = new Heap();
		int[] a = { 17, 8, 45, 84, 2, 94 };
		h.heap_sort(a, a.length - 1);
	}
}