package file;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

public class FileDeal {

	public static Map<String, String> map = Maps.newHashMap();
	public static String sql = "update feed_template SET push_title= '%s',push_content='%s' where template_type  = '%s';";

	static {
		// map.put("\u4e1c\u5357","东南");
		map.put("\\u5357", "南");
		// map.put("\u4e1c\u5317","东北");
		map.put("\\u4e1c", "东");
		// map.put("\u897f\u5357","西南");
		// map.put("\u897f\u5317","西北");
		map.put("\\u4e0d\\u9650", "不限");
		map.put("\\u897f", "西");
		map.put("\\u5317", "北");
		// map.put("","不限");
	}

	public static void main(String[] args) throws Exception {
		File inFile = new File("D://pushFile2.txt");
		File dbSql = new File("D://db.sql");
		List<String> list = FileUtils.readLines(inFile);
		List<String> dbList = FileUtils.readLines(dbSql);
		File outFile = new File("D://update.txt");

		for (String str : list) {
			String[] tmp = str.split("\t");
			// System.out.println(tmp[0]);
			// System.out.println(tmp.length);
			String sqlStr = String.format(sql, tmp[1],tmp[2],tmp[0]);
			FileUtils.write(outFile, sqlStr+"\n", true);
		}
	}

	public static void dealDate(String str, Set<String> set) {
		set.add(str);
	}
}
