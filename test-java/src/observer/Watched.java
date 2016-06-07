package observer;

import observer.util.Observable;

/**
 * 被观察对象
 * 
 * @author chaos
 */
public class Watched extends Observable {
	private String data = "";

	public String retrieveData() {
		return data;
	}

	public void changeData(String data) {
		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}

		notifyObservers();
	}
}
