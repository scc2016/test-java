package callback;

public class Test {
	public static void main(String[] args) {
		Caller caller = new Caller();
		caller.setCallFunc(new Client());
		caller.call();
	}
}
