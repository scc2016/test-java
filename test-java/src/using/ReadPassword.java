package using;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 读取密码
 * @author chaos
 *
 */
public class ReadPassword {
	public static void main(String[] args) {
		String usePlace = "";
		String url = " ";
		String name = "";
		boolean showAll = true;

		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器
		System.out.println("请输入key：");
		String key = scanner.nextLine();// 获取用户输入的一行文本
		// 打印对输入文本的描述

		File file = new File("D:\\password.txt");
		if (file.exists()) {
			try {
				// Student对象反序列化过程
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Map<String, Password> passwordMap = (HashMap<String, Password>) ois.readObject();
				ois.close();
				fis.close();
				for (String useP : passwordMap.keySet()) {
					Password password = passwordMap.get(useP);
					if (showAll || password.getName().equalsIgnoreCase(name) || password.getUsePlace().equals(usePlace)
							|| password.getUrl().equalsIgnoreCase(url)) {
						password.printPasswordInfo(key);
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}