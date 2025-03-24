import java.util.ArrayList;

public class UsersAggregate implements Aggregate<User>{ //create concrete iterator that iterates ove users
    private static ArrayList<User> users;

    public UsersAggregate(ArrayList<User> user) {
        users=user;
    }

    @Override
    public Iterator<User> createIterator() {
        return new UserIterator(users);
    }
}
