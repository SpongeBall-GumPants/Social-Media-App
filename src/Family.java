import java.util.ArrayList;

public class Family implements Relation{//famil factory  creates this


    private String name;
    private ArrayList<User> members;
    public Family(String groupName){
        name=groupName;
        members=new ArrayList<>();
    }

    @Override
    public String getName(){return name;}
    @Override
    public ArrayList<User> getMembers() {return members;}
    @Override
    public void join(User user){members.add(user);}
    @Override
    public void leave(User user){members.remove(user);}
    @Override
    public  void connect(User user){

        new InsideFamily(this,user);
    }
    @Override
    public int checkUser(User checkedUser){

        UsersAggregate usersAggregate = new UsersAggregate(members);
        Iterator<User> iterator = usersAggregate.createIterator();
        iterator.resetIndex();

        while (iterator.hasNext()) {
            User temp = iterator.next();
            if (temp.getUserName().equals(checkedUser.getUserName())) {
                return 1;
            }
        }
        return 0;



    }
}
