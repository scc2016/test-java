package threadcallback;

public class Test {
	public static void main(String[] args) {
		Remote remote = new Remote();
		String message = "Hello";
		Local local = new Local(remote, message);
		local.sendMessage();
	}
}
