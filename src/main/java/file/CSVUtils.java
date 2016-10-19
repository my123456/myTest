package file;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import time.DateUtil;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class CSVUtils {
	private static final String EXTENDSION_NAME = ".csv";
	private final static byte HEAD[] = { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };

	public static File createCSVFile(String content, String outPutPath, String fileName) {
		File csvFile = null;
		BufferedWriter stream = null;

		try {
			File file = new File(outPutPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 定义文件名格式并创建
			csvFile = File.createTempFile(fileName, EXTENDSION_NAME, new File(outPutPath));
			// UTF-8使正确读取分隔符","
			stream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
			stream.write(new String(HEAD));
			// 写入文件头部
			if (StringUtils.isNotBlank(content)) {
				stream.write(content);
			}
			stream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}

	

	public static String readFileHeader(String fileName) {
		File file = new File(fileName + EXTENDSION_NAME);
		String str = "";
		try {
			str = Files.readFirstLine(file, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static void fillCvsCell(Map<String, Object> map, String key, StringBuffer s) {
		fillCvsCell(map, key, s, false);
	}

	public static void fillCvsCell(Map<String, Object> map, String key, StringBuffer s, boolean hasTab) {
		Object value = map.get(key);
		if (value != null) {
			s.append(value.toString());
		}
		if (hasTab) {
			s.append("\t");
		}
		s.append(",");
	}

	public static void fillCvsCell(Object value, StringBuffer s) {
		fillCvsCell(value, s, false);
	}

	public static void fillCvsCell(Object value, StringBuffer s, boolean hasTab) {
		if (value != null) {
			if (value instanceof Date) {
				s.append(DateUtil.getDateString((Date) value));
			} else {
				s.append(value.toString());
			}
			if (hasTab) {
				s.append("\t");
			}
		}
		s.append(",");
	}
	
	/**
	 * 解析csv文件
	 */
	public static List<List<String>> readCSVFile(String file) {
		List<List<String>> list = new ArrayList<List<String>>();
		InputStreamReader fr = null;
		BufferedReader br = null;
		try {
			fr = new InputStreamReader(new FileInputStream(file));
			br = new BufferedReader(fr);
			String rec = null;
			while ((rec = br.readLine()) != null) {
				List<String> cells = new ArrayList<String>();
				String line = rec.trim();
				String[] str = line.split(",");
				for (String s : str) {
					cells.add(s);
				}
				list.add(cells);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {

			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		CSVUtils.createCSVFile("今天,天真好,123,abc", "E:/", "abc");
	}
}
