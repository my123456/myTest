package customer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;

import print.FileShowUtil;

public class FileContentDealN14 {
	

	public static void main(String[] args) throws IOException {
		printSelect1();
	}
	
	private static void searchQuery(){
		Pattern p1 = Pattern.compile("((\\d*)(-)(\\d*))");
		Pattern p2 = Pattern.compile("(\\d*)");
		ImmutableMultimap<String, String> rentMap = ImmutableMultimap.of("1","prices","2","prices");
		List<String[]> list = parseFileContent("D://config.txt");
		String city = "350200";
		String searhc_condition = "INSERT INTO `cust_common`.`search_condition` (`city_code`, `demand_type`, `search_type`, `value`) VALUES ('"+city+"', '%s', 'prices', '%s');";
		for(String[] strs: list){
			int i=0;
			StringBuffer sb = new StringBuffer();
			for(String str:strs){
				if(i==0){
					Matcher m = p2.matcher(str);
					if(m.find()){
						String s = m.group(0);
						sb.append("[[\\\"").append("0,").append(s).append("\\\",\\\"").append(str).append("\\\"]").append(",");
					}else{
						System.out.println("erro in p1"+str);
						return;
					}
				}else{
					Matcher m = p1.matcher(str);
					if(m.find()){
						String[] s = m.group(0).split("-");
						sb.append("[\\\"").append(s[0]).append(",").append(s[1]).append("\\\",\\\"").append(str).append("\\\"]").append(",");
					}else{
						m=p2.matcher(str);
						if(m.find()){
							String s = m.group(0);
							sb.append("[\\\"").append(s).append(",").append("\\\",\\\"").append(str).append("\\\"]]");
						}else{
							System.out.println("erro in p2"+str);
							return;
						}
					}
				}
				i++;
			}
			String sql = String.format(searhc_condition, 1,sb.toString());
			System.out.println(sql);
		}
	}
	
	private static void printSelect1() {
		List<String[]> list = parseFileContent("D://d1.txt");
		String c = "INSERT INTO `cust_common`.`delegate_source` (`id`, `city_code`, `parent_id`, `name`, `is_del`) VALUES";
		int begin = 566;
		String city = "131000";
		Map<String, Integer> map1 = new LinkedHashMap<String, Integer>();
		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();
		Map<String, Integer> map3 = new LinkedHashMap<String, Integer>();
		for (String[] arr : list) {
		   if (map1.get(arr[0]) == null) {
			  map1.put(arr[0], begin++);
		   }
		}
		for (String[] arr : list) {
		   map2.put(arr[1], begin++);
		   map3.put(arr[1], map1.get(arr[0]));
		}

		List<String> sql = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map1.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			String s = c + " (\'" + value + "\', " + "\'" + city + "\', \'0\', " + "\'" + key + "\', \'0\');";
			sql.add(s);
		}
		for (Map.Entry<String, Integer> entry : map2.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			String s = c + " (\'" + value + "\', " + "\'" + city + "\', \'" + map3.get(key) + "\', " + "\'" + key + "\', \'0\');";
			sql.add(s);
		}
		FileShowUtil.getFileShowUtil().print(sql);
		
		List<String[]> d2 = parseFileContent("D://d2.txt");
		List<String> fs = new ArrayList<String>();
		for (String[] arr : d2) {
			String delegateS = arr[1];
			String first = arr[2];
			String second = arr[3];
			String key = map1.get(first) + ";" + map2.get(second);
			key = delegateS + "=" + key;
			fs.add(key);
		}
		FileShowUtil.getFileShowUtil().print(sql);
	}

	public static List<String[]> parseFileContent(String filename) {
		List<String[]> result = new ArrayList<String[]>();
		BufferedReader bufferedReader = null;
		try {
			FileInputStream stream = new FileInputStream(filename);
			bufferedReader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				try {
					if (StringUtils.isNotBlank(lineTxt)) {
						String[] arr = lineTxt.split("\t");
						result.add(arr);
					}
				} catch (Exception e) {
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
