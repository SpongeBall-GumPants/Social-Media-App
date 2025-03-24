import java.util.ArrayList;

public class GroupAggregate implements Aggregate<Group>{//concrete iterator creator (group iterator)
    private static ArrayList<Group> groups;
    public GroupAggregate(ArrayList<Group> groups1){
        groups=groups1;
    }
    @Override
    public Iterator<Group> createIterator(){
        return new GroupIterator(groups);
    }

}
