import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HelloScc {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Map map = new TreeMap<String, String>();
		map.get(null);

		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			it.remove();
		}
		if (map.containsKey("sss")) {
			System.out.println("sss");
		} else {
			map.get("sss");
			System.out.println("111");
		}
	}
}