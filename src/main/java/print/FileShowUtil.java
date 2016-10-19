package print;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class FileShowUtil extends AbstractPrint {
	static Print print;

	private FileShowUtil() {
	}
	
	public static Print getFileShowUtil() {
		if (print == null) {
			synchronized (Print.class) {
				if (print == null) {
					print = new FileShowUtil();
				}
			}
		}
		return print;
	}

	@Override
	public void printString(String content) {
		String filename = FileConstants.TXT + RandomDataUtil.getRandomNumber(10) + FileConstants.TXT;
		boolean flag = FileUtilN2.saveFile(filename, content);
		if (flag) {
			try {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void printTimeVo(List<TimeVo> list) {
		if (list != null && list.size() > 0) {
			StringBuffer sb = new StringBuffer("<!DOCTYPE html><html>");
			sb.append("<head><meta http-equiv=\"content-type\"");
			sb.append("content=\"text/html;charset=utf-8\"></head>");
			sb.append("<body><table border=\"1\">");
			sb.append("<tr>");
			sb.append("<th>").append("线程").append("</th>");
			sb.append("<th>").append("时间").append("</th>");
			sb.append("<th>").append("结果").append("</th>");
			sb.append("</tr>");
			for (TimeVo obj : list) {
				sb.append("<tr>");
				sb.append("<th>").append(((TimeVo) obj).getService()).append("</th>");
				sb.append("<th>").append(((TimeVo) obj).getLogTime()).append("</th>");
				sb.append("<th>").append(JSON.toJSONString(((TimeVo) obj).getResult(), true)).append("</th>");
				sb.append("</tr>");
			}
			sb.append("</table></body></html>");
			printString(sb.toString());
		}
	}

	@Override
	public String getSpLine() {
		return "\n\r";
	}
}