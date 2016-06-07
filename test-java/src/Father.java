public class Father {
	private String pri = "pri-father";
	protected String pro = "pr0-father";
	public String pub = "pub-father";

	public Father() {
		pri = "pri-father";
		pro = "pr0-father";
		pub = "pub-father";
	}

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

}
