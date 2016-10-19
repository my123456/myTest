package design;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonTest implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {// 以下代码实现序列化
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://my.out"));// 输出流保存的文件名为
																							// ；ObjectOutputStream能把Object输出成Byte流
			Singleton myTest = new Singleton();
			oos.writeObject(myTest);
			oos.flush(); // 缓冲流
			oos.close(); // 关闭流
			Singleton myTest2 = fan();// 调用下面的 反序列化 代码
			System.out.println(myTest == myTest2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("resource")
	public static Singleton fan()// 反序列的过程
	{
		ObjectInputStream oin = null;// 局部变量必须要初始化
		try {
			oin = new ObjectInputStream(new FileInputStream("D://my.out"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Singleton mts = null;
		try {
			mts = (Singleton) oin.readObject();// 由Object对象向下转型为MyTest对象
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("name=" + mts.getName());
		System.out.println("age=" + mts.getAge());
		return mts;
	}
}