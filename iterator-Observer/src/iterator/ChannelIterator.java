package iterator;

import observable.YouTubeChannel;
import observer.IObserver;
import java.util.List;

public class ChannelIterator implements IIterator {

    private int index;
    private YouTubeChannel channel;

    public ChannelIterator(YouTubeChannel channel) {
        this.channel = channel;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        List<IObserver> observers = channel.getObservers();
        return index < observers.size();
    }

    @Override
    public IObserver next() {
        List<IObserver> observers = channel.getObservers();
        if (hasNext()) {
            return observers.get(index++);
        }
        return null;
    }
}