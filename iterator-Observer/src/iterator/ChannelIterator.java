public class ChannelIterator implements IItrerator {
    private int index;
    private YouTubeChannel channel;

    public ChannelIterator(YouTubeChannel channel) {
        this.channel = channel;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < channel.getUser().size();
    }

    @Override
    public IObserver next() {
        if (hasNext()) {
            return channel.getUser().get(index++);
        }
        return null;
    }

}
