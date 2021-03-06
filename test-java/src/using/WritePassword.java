package using;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 存密码
 * 
 * @author scc
 */
public class WritePassword {
	public static void main(String[] args) throws Exception {
		Password password = new Password();

		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器
		System.out.println("请输入key：");
		String key = scanner.nextLine();// 获取用户输入的一行文本

		System.out.println("请输入usePlace：");
		String usePlace = scanner.nextLine();// 获取用户输入的一行文本

		System.out.println("请输入url：");
		String url = scanner.nextLine();// 获取用户输入的一行文本

		System.out.println("请输入name：");
		String name = scanner.nextLine();// 获取用户输入的一行文本

		System.out.println("请输入password：");
		String passw = scanner.nextLine();// 获取用户输入的一行文本

		password.setUsePlace(usePlace);
		password.setUrl(url);
		password.setName(name);
		password.encryPassword(passw, key);

		File file = new File("D:\\password.txt");
		try {
			Map<String, Password> passwordMap = new HashMap<String, Password>();
			if (file.exists()) {
				// List对象反序列化过程,读取至list对象
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				passwordMap = (HashMap<String, Password>) ois.readObject();
				ois.close();
				fis.close();
			}
			// 加入新加对象
			passwordMap.put(usePlace, password);
			// List对象序列化
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(passwordMap);
			oos.flush();
			oos.close();
			fos.close();
			System.out.println(usePlace + "存储成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}