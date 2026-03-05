package observable;

public class YouTubeChannel implements IObservable {
    private List<IObserver> observers;

    public YouTubeChannel() {
        observers = new ArrayList<>();
    }
    public void attach(IObserver observer) {
        observers.add(observer);
    }
    public void detach(IObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
       
    }
     public Iterator<IObserver> createIterator() {
        return observers.iterator();
    }
}
