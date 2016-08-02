package using;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 删除密码功能
 * 
 * @author scc
 */
public class DeletePasswordByCount {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器

		System.out.println("请输入key：");
		String key = scanner.nextLine();

		File file = new File("D:\\password.txt");
		try {
			if (file.exists()) {
				// Student对象反序列化过程
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Map<String, Password> passwordMap = (HashMap<String, Password>) ois.readObject();
				ois.close();
				fis.close();
				int i = 0;
				for (String useP : passwordMap.keySet()) {
					Password password = passwordMap.get(useP);
					System.out.print("序号：" + i + " ");
					i++;
					password.printPasswordInfo(key);
				}

				System.out.println("请输入要删除的密码的序号：");
				String countStr = scanner.nextLine();
				int count = Integer.parseInt(countStr);

				Iterator<Map.Entry<String, Password>> it = passwordMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, Password> entry = it.next();
					if (count == 0) {
						it.remove();
						System.out.println(entry.getKey() + "被删除！");
						break;
					} else {
						count--;
					}
				}
				// List对象序列化
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(passwordMap);
				oos.flush();
				oos.close();
				fos.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}