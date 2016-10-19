package file;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.lianjia.common.util.BeanUtil;

public class TestUnicode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "你好";

		// 编码
		byte[] utf = s.getBytes("utf-8");
		byte[] gbk = s.getBytes("gbk");

		System.out.println("utf-8编码：" + Arrays.toString(utf)); // [-28, -67,
																// -96, -27,
																// -91, -67]
																// 6个字节
		System.out.println("gbk编码：" + Arrays.toString(gbk)); // [-60, -29, -70,
																// -61]<span
																// style="white-space:pre">
																// </span>4个字节

		// 解码
		String s1 = new String(utf, "utf-8"); // 你好
		String s2 = new String(utf, "gbk");// gbk解码：浣犲ソ gbk用2个字节解码，所以会多一个字符
		String s3 = new String(gbk, "utf-8");// gbk用utf-8解码：??? <span
		String s4 = new String(gbk, "gbk");// gbk用utf-8解码：??? <span

		System.out.println("--------------------");
		System.out.println("utf-8解码：" + s1);
		System.out.println("gbk解码：" + s2);
		System.out.println("gbk用utf-8解码：" + s3);
		System.out.println("gbk用gbk解码：" + s4);
		System.out.println("---------------------");

		System.out.println("用utf-8编码回去");

		s3 = new String(s3.getBytes("utf-8"), "gbk"); // 锟斤拷锟? gbk用utf-8解码后无法编回去

		System.out.println(s3);
		
		s2 = new String(s2.getBytes("gbk"), "utf-8"); // 锟斤拷锟? gbk用utf-8解码后无法编回去
		System.out.println(s2);
	}
}
