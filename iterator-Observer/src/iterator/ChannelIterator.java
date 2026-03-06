package iterator;

import observable.YouTubeChannel;
import observer.IObserver;
import java.util.List;

public class ChannelIterator implements IIterator {

    // Posición actual dentro de la lista
    private int index;

    // Referencia al canal que contiene los observadores
    private YouTubeChannel channel;

    /**
     * Constructor del iterador.
     * Recibe el canal para poder acceder a la lista de suscriptores.
     */
    public ChannelIterator(YouTubeChannel channel) {
        this.channel = channel;
        this.index = 0;
    }

    /**
     * Verifica si todavía quedan elementos por recorrer.
     * 
     * @return true si hay más observadores en la lista
     */
    @Override
    public boolean hasNext() {
        List<IObserver> observers = channel.getObservers();
        return index < observers.size();
    }

    /**
     * Devuelve el siguiente observador de la lista
     * y avanza la posición del iterador.
     * 
     * @return el siguiente IObserver
     */
    @Override
    public IObserver next() {
        List<IObserver> observers = channel.getObservers();

        if (hasNext()) {
            return observers.get(index++);
        }

        return null;
    }
}