package print;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractPrint implements Print {

	public <T> void print(T... t) {
		if (t == null) {
			printString("");
			return;
		}
		for (T tmp : t) {
			if (tmp != null && tmp instanceof TimeVo) {
				List<TimeVo> l = new ArrayList<TimeVo>();
				l.add((TimeVo) tmp);
				printTimeVo(l);
			} else if (tmp != null && tmp instanceof List && ((List) tmp).size() > 0 && ((List) tmp).get(0) != null
					&& ((List) tmp).get(0) instanceof TimeVo) {
				printTimeVo((List<TimeVo>) tmp);
			} else if (tmp != null && tmp instanceof List && ((List) tmp).size() > 0 && ((List) tmp).get(0) != null
					&& ((List) tmp).get(0) instanceof String) {
				printString((List<String>) tmp);
			} else if (tmp != null && tmp instanceof String) {
				printString((String)tmp);
			} else {
				printString(JSON.toJSONString(tmp, false));
			}
		}
	}

	public abstract void printTimeVo(List<TimeVo> list);

	public abstract void printString(String content);
	
	public abstract String getSpLine();
	
	public void printString(List<String> list) {
		StringBuffer sb = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (String s : list) {
				sb.append(s).append(getSpLine());
			}
		}
		printString(sb.toString());
	}
}
