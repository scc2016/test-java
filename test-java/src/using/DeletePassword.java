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
 * 
 * @author scc
 */
public class DeletePassword {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器

		System.out.println("请输入要删除的usePlace：");
		String usePlace = scanner.nextLine();// 获取用户输入的一行文本

		File file = new File("D:\\password.txt");
		try {
			if (file.exists()) {
				Map<String, Password> passwordMap = new HashMap<String, Password>();
				// List对象反序列化过程,读取至list对象
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				passwordMap = (HashMap<String, Password>) ois.readObject();
				ois.close();
				fis.close();

				Iterator<Map.Entry<String, Password>> it = passwordMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, Password> entry = it.next();
					if (entry.getKey().equals(usePlace)) {
						it.remove();
						System.out.println(usePlace + "被删除！");
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