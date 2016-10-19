package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

	/**
	 * test
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String infile = "F:\\se-customer.zip";
		String outfile = "F:\\a.zip";
		String outfile2 = "F:\\a1.zip";
		File inputFile = new File(infile);
		File outFile = new File(outfile);
		File outFile2 = new File(outfile2);
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			normalCopy(inputFile, outFile);
			long end1 = System.currentTimeMillis();
			nioCopy(inputFile, outFile2);
			long end2 = System.currentTimeMillis();

			System.out.println("normal copy lasts: " + (end1 - start));
			System.out.println("nio copy lasts: " + (end2 - end1));
		}
	}

	// nio文件复制功能
	public static void nioCopy(File infile, File outfile) throws Exception {
		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (true) {
			buffer.clear();
			int r = fcin.read(buffer);
			if (r == -1) {
				break;
			}
			buffer.flip();
			fcout.write(buffer);
		}

		fcin.close();
		fcout.close();
		fin.close();
		fout.close();
	}

	// 普通I/O文件复制功能
	public static void normalCopy(File infile, File outfile) throws Exception {
		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);
		byte[] block = new byte[1024];
		while (fin.read(block) != -1) {
			fout.write(block);
		}
		fin.close();
		fout.close();
	}

}