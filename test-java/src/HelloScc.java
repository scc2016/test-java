import java.util.Scanner;

public class HelloScc {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器
		System.out.println("请输入数字：");// 提示用户输入
		String line = scanner.nextLine();// 获取用户输入的一行文本
		// 打印对输入文本的描述
		System.out.println("原来是" + line.length() + "位数字的啊");
		System.out.println("请输入数字：");// 提示用户输入
		line = scanner.nextLine();// 获取用户输入的一行文本
		// 打印对输入文本的描述
		System.out.println("原来是" + line.length() + "位数字的啊");
	}

}
