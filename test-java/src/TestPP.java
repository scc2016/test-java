public class TestPP {

	public String ss = null;

	public TestPP() {
		ss = "pp";
	}

	public String getSs() {
		ss = "changeg";
		System.out.println("ppgetSs_ss" + ss);
		return ss;
	}

	public void ssss() {
		TestBB tb = new TestBB() {
			public String getSs() {
				System.out.println("this.ss" + ss);
				System.out.println("TestPP.this.ss" + TestPP.this.ss);
				return ss;
			}
		};
		tb.getSs();
	}
}
