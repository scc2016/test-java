public class TestMain {

	// public static void main(String[] args) {
	// Student s1 = new Student("zhangsan", 18);
	// Student s2 = (Student) s1.clone();
	// s2.name = "lisi";
	// s2.age = 20;
	// System.out.println("name=" + s1.name + "," + "age=" + s1.age);//
	// 修改学生2后，不影响学生1的值。
	// }

	public static void main(String[] args) {
		// int a = 2;
		// System.out.println(a + 3 * a++);
		// Map<String, String> rr = new HashMap<String, String>();
		// JSONObject sss = new JSONObject();
		// try {
		// sss.put("ttt", "2111");
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// rr.put("sss", obj.toString());
		// System.out.println(rr.get("sss"));
		// Sun sun = new Sun();
		// System.out.println(sun.getPri());
		// System.out.println(sun.getPro());
		// System.out.println(sun.getPub());
		// String sss = "123";
		// sss.substring(4, 5);

		// Integer s = new Integer(1);
		// if (1 == 1) {
		// s = null;
		// }
		// if (s.intValue() == 1) {
		//
		// }

		// int i = s;

		// for (int i = 0; i < 10; i++) {
		// for (int j = 0; j < 30; j++) {
		// System.out.print("*");
		// }
		// System.out.println();
		// }
		// Map M = new Hashtable();
		System.out.println(88798 % 300);
	}
}

class Student implements Cloneable {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Object clone() {

		Object o = null;
		try {
			o = (Student) super.clone();// Object 中的clone()识别出你要复制的是哪一个对象。
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		return o;
	}
}