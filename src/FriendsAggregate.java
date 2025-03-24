import java.util.List;

public class FriendsAggregate implements Aggregate<Observer> {///concrete iterator creator  friends list
    private List<Observer> friends;

    public FriendsAggregate(List<Observer> friends) {
        this.friends = friends;
    }

    @Override
    public Iterator<Observer> createIterator() {
        return new FriendsIterator(friends);
    }
}
