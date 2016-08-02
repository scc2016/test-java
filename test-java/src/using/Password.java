package using;

import java.io.Serializable;
/**
 * model密码存储类
 * @author chaos
 *
 */
public class Password implements Serializable {
	private String usePlace;
	private String url;
	private String name;
	private String encryptedPassword;

	public Password() {
		this.usePlace = "";
		this.url = "";
		this.name = "";
		this.encryptedPassword = "";
	}

	public String getUsePlace() {
		return usePlace;
	}

	public void setUsePlace(String usePlace) {
		this.usePlace = usePlace;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String queryPassword(String key) throws Exception {
		return AESSecurityUtil.decrypt(this.encryptedPassword, key);
	}

	public void encryPassword(String password, String key) throws Exception {
		this.encryptedPassword = AESSecurityUtil.encrypt(password, key);
	}

	public void printPasswordInfo(String key) throws Exception {
		System.out.println("【usePlace】:" + StringUtil.addUOfLength(this.usePlace, 10) + " 【URL】:"
				+ StringUtil.addUOfLength(this.url, 15) + " 【name】:" + StringUtil.addUOfLength(this.name, 25)
				+ " 【password】:" + this.queryPassword(key));
	}
}
