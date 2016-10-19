import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class StringBufferTest {
	public void test(StringBuffer sb) {
		sb.append("abc|");
	}

	public static void main(String[] args) {
		String str = "+	+123	+123	-123	--	";
		System.out.println(str.replaceAll("\\s*", "").replace("-", "").replace("+", ""));
		Set<Long> set = new HashSet<Long>();
		set.add(1L);
		if (set.contains(1L)) {
			System.out.println("+++");
		} else {
			System.out.println("--");
		}
		set.clear();
		if (set.contains(1L)) {
			System.out.println("+++");
		} else {
			System.out.println("--");
		}
		Long a = null;
		System.out.println(a + "");
		StringBuffer sb = new StringBuffer("12|");
		// sb.insert(0, "abc|");
		System.out.println(sb.toString().split("\\|").length);
		System.out.println(sb.toString().split("\\|")[0]);
		// StringBufferTest sbt = new StringBufferTest();
		// sbt.test(sb);
		// System.out.println(sb);
		//
		// String s = new String("");
		// System.out.println(StringUtils.isNotBlank(s));
		// System.out.println(StringUtils.isNoneBlank(s));
	}
}
