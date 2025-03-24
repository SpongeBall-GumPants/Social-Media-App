import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UserIterator implements Iterator<User> {//concrete iterate over users
    private int currentIndex = 0;
    private  ArrayList<User> users;

    public UserIterator(ArrayList<User> user) {
       this.users = user;
    }

    @Override
    public boolean hasNext() {
        if(users==null){return false;}
        return currentIndex < users.size();
    }

    @Override
    public User next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return users.get(currentIndex++);
    }
    public void resetIndex(){
        currentIndex=0;
    }

}