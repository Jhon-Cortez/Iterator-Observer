package iterator;

import observer.IObserver;

public interface IIterator {
    boolean hasNext();
    IObserver next();
}
