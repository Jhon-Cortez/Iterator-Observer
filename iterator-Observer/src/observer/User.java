package observer;

public class User implements IObserver {
    
    private String name;
    
    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String data) {
        System.out.println(name + " received notification: " + data);
    }
}