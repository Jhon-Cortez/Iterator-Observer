package observable;

import java.util.ArrayList;
import java.util.List;
import observer.IObserver;
import iterator.IIterator;
import iterator.ChannelIterator;
import iterator.IAggregate;
import observer.User;

public class YouTubeChannel implements IObservable, IAggregate {

    private List<IObserver> observers;

    public YouTubeChannel() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String data) {

        IIterator iterator = createIterator();

        while (iterator.hasNext()) {
            IObserver observer = iterator.next();
            observer.update(data);
        }
    }

    @Override
    public IIterator createIterator() {
        return new ChannelIterator(this); 
    }

    public void publishVideo(String title) {
        System.out.println("New video: " + title);
        notifyObservers(title);
    }

    public List<IObserver> getObservers() {
        return observers;
    }

    // 🔥 NUEVOS MÉTODOS AQUÍ ABAJO

    public void addSubscriber(String name) {
        attach(new User(name));
    }

    public void removeSubscriber(String name) {

        IIterator iterator = createIterator();
        User toRemove = null;

        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (user.getName().equalsIgnoreCase(name)) {
                toRemove = user;
                break;
            }
        }

        if (toRemove != null) {
            detach(toRemove);
            System.out.println("Subscriber removed!");
        } else {
            System.out.println("Subscriber not found.");
        }
    }

    public void showSubscribers() {

        IIterator iterator = createIterator();

        System.out.println("\nSubscribers:");

        if (!iterator.hasNext()) {
            System.out.println("No subscribers yet.");
            return;
        }

        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            System.out.println("- " + user.getName());
        }
    }
}