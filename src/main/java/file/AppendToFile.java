package file;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendToFile {
    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "D:/newTemp.txt";
        String content = "new append!\n";

        long time = System.currentTimeMillis();
        FileWriter writer = new FileWriter(fileName, true);
        for (int i = 0; i < 1000; i++) {
            writer.write(content);
        }
        writer.close();
        AppendToFile.appendMethodB(fileName, content);
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        content = "new append!\n";
        for (int i = 0; i < 1000; i++) {
            File file = new File("D:/newTemp2.txt");
            FileUtils.writeStringToFile(file, content, "UTF-8", true);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}