package design;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Main {
	private State state;

	public List<String> getComments(String input) {
		List<String> list = new ArrayList<String>();
		int virStart = 0, docStart = 0, comStart = 0;

		state = State.READ_SKIP.read(input.charAt(0));

		for (int i = 1; i < input.length(); i++) {
			state = state.read(input.charAt(i));
			if (state.equals(State.DOUBLE_VIRGULE)) {
				virStart = i - 1;
			} else if (state.equals(State.DOCUMENT_START)) {
				docStart = i - 2;
			} else if (state.equals(State.COMMENT_START)) {
				comStart = i - 1;
			} else if (state.equals(State.END_VIRGULE)) {
				list.add("单行注释:" + input.substring(virStart, i + 1));
			} else if (state.equals(State.END_DOCUMENT)) {
				list.add("文档注释:" + input.substring(docStart, i + 1));
			} else if (state.equals(State.END_COMMENT)) {
				list.add("文本注释:" + input.substring(comStart, i + 1));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader());
		Human h = new Human();
		{
			User user = new User();
			user.setName("123");
			h.setUser(user);
		}
		System.out.println(JSON.toJSONString(h));
	}
}