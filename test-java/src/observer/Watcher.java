package observer;

import observer.util.Observable;
import observer.util.Observer;

public class Watcher implements Observer {
	public Watcher(Watched w) {
		w.addObserver(this);
	}

	public void update(Observable ob, Object arg) {
		System.out.println("Data has been changed to: '"
				+ ((Watched) ob).retrieveData() + "'");
	}

}
