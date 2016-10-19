import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableSet;

public class ImmutableSetTest {
	public static  ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");

	class Foo {
		Set<String> bars;

		Foo(Set<String> bars) {
			this.bars = ImmutableSet.copyOf(bars); // defensive copy!
		}
	}

	public static void main(String[] args) {
		COLOR_NAMES.add("123");
		System.out.println(JSON.toJSONString(COLOR_NAMES, true));
		Set<String> bars=ImmutableSet.copyOf(COLOR_NAMES); // defensive copy!
		System.out.println(JSON.toJSONString(bars, true));
	}
}
