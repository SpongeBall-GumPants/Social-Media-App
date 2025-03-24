import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GroupIterator implements Iterator<Group>{//concrete iterator for going through group members
    private int currentIndex = 0;
    private ArrayList<Group> groups;

    public GroupIterator(ArrayList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean hasNext() {
        if(groups==null){return false;}
        return currentIndex < groups.size();
    }

    @Override
    public Group next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return groups.get(currentIndex++);
    }
    public void resetIndex(){
        currentIndex=0;
    }
}