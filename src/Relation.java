import java.util.ArrayList;

interface Relation {//relations can be expanded: we currently have groups and families
    Database database=Database.getDatabase();
    public String getName();

    public ArrayList<User> getMembers();
    public void join(User user);
    public void leave(User user);
    public void connect(User user);
    public int checkUser(User user);
}
