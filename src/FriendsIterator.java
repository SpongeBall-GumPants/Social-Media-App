import java.util.List;
import java.util.NoSuchElementException;


public class FriendsIterator implements Iterator<Observer> {//concrete iterator for going through a users friends
    private int currentIndex = 0;
    private List<Observer> friends;

    public FriendsIterator(List<Observer> friends) {
        this.friends = friends;
    }

    @Override
    public boolean hasNext() {
        return friends != null && currentIndex < friends.size();
    }

    @Override
    public Observer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return friends.get(currentIndex++);
    }

    public void resetIndex() {
        currentIndex = 0;
    }

}
