package using;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author scc
 */
public class WritePassword {
	public static void main(String[] args) throws Exception {
		Password password = new Password();
		String usePlace = "苏宁易购";
		password.setUrl("");
		password.setName("");
		String passw = "";

		String key = "";

		password.setUsePlace(usePlace);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}