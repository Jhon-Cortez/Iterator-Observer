package observer;

public class User implements IObserver {

    @Override
    public void update(Object data) {
        System.out.println("User received notification: " + data);
    }
}