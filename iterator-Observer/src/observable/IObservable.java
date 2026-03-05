package observable;

import observer.IObserver;

public interface IObservable {

    public void attach(IObserver observer);
    public void detach(IObserver observer);
    public void notifyObservers(String data);
}