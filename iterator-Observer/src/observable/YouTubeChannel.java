package observable;

import java.util.ArrayList;
import java.util.List;
import observer.IObserver;
import iterator.IIterator;
import iterator.ChannelIterator;
import iterator.IAggregate;
import observer.User;

public class YouTubeChannel implements IObservable, IAggregate {

    // Lista de observadores (suscriptores del canal)
    private List<IObserver> observers;

    /**
     * Constructor del canal.
     * Inicializa la lista de suscriptores.
     */
    public YouTubeChannel() {
        observers = new ArrayList<>();
    }

    /**
     * Agrega un nuevo observador (suscriptor) al canal.
     */
    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador (suscriptor) del canal.
     */
    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a todos los suscriptores cuando ocurre un evento.
     * 
     * En este caso se usa el Iterator para recorrer la lista
     * de observadores.
     */
    @Override
    public void notifyObservers(String data) {

        IIterator iterator = createIterator();

        while (iterator.hasNext()) {
            IObserver observer = iterator.next();
            observer.update(data);
        }
    }

    /**
     * Crea un iterador para recorrer los observadores.
     */
    @Override
    public IIterator createIterator() {
        return new ChannelIterator(this); 
    }

    /**
     * Publica un nuevo video en el canal.
     * Todos los suscriptores reciben la notificación.
     */
    public void publishVideo(String title) {
        System.out.println("New video: " + title);
        notifyObservers(title);
    }

    /**
     * Devuelve la lista de observadores.
     * Se usa principalmente por el Iterator.
     */
    public List<IObserver> getObservers() {
        return observers;
    }
    
    /**
     * Agrega un nuevo suscriptor al canal usando su nombre.
     */
    public void addSubscriber(String name) {
        attach(new User(name));
    }

    /**
     * Elimina un suscriptor buscando por su nombre.
     * Utiliza el Iterator para recorrer la lista.
     */
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

    /**
     * Muestra todos los suscriptores del canal.
     * Utiliza el Iterator para recorrer la colección.
     */
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