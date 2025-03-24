
import java.util.ArrayList;

public class Database {//Singleton

    private static ArrayList<Group> groups;
    private static ArrayList<Family> families;

    private static ArrayList<User> users;
    private static Database database=null;



    private Database() {
        users=new ArrayList<>();
        groups=new ArrayList<>();
        families=new ArrayList<>();

    }

    public static Database getDatabase() {//Singleton implementation
        if(database==null){
            database = new Database();

        }

        return Database.database;
    }

    //////general getters and setters :
    public static ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }
    public void addGroup(Group group){groups.add(group);}
    public void addFamily(Family family){families.add(family);}



///// getters that use iterators for getting and/or checkking specific members of list fields:

    public ArrayList<String> getGroupNames(){

        ArrayList<String> relationNames=new ArrayList<>();
        GroupAggregate groupAggregate=new GroupAggregate(groups);
        Iterator<Group> iterator = groupAggregate.createIterator();
        iterator.resetIndex();
        while (iterator.hasNext()){
            Relation temp=iterator.next();
            relationNames.add(temp.getName());

        }
        return relationNames;
    }
    public ArrayList<String> getFamilyNames(){
        ArrayList<String> relationNames=new ArrayList<>();
        FamilyAggregate familyAggregate=new FamilyAggregate(families);
        Iterator<Family> iterator = familyAggregate.createIterator();
        iterator.resetIndex();
        while (iterator.hasNext()){
            Relation temp=iterator.next();
            relationNames.add(temp.getName());

        }
        return relationNames;
    }

    public Family searchFamily(String str){
        ArrayList<String> relationNames=new ArrayList<>();
        FamilyAggregate familyAggregate=new FamilyAggregate(families);
        Iterator<Family> iterator = familyAggregate.createIterator();
        iterator.resetIndex();
        while (iterator.hasNext()){
            Family temp=iterator.next();
            if(str.equals(temp.getName())){
                return temp;
            }

        }
        return null;
    }
    public Group searchGroup(String str){
        ArrayList<String> relationNames=new ArrayList<>();
        GroupAggregate groupAggregate=new GroupAggregate(groups);
        Iterator<Group> iterator = groupAggregate.createIterator();
        iterator.resetIndex();
        while (iterator.hasNext()){
            Group temp=iterator.next();
            if(str.equals(temp.getName())){
                return temp;
            }

        }
        return null;
    }





    public int checkUser(User checkedUser){
        User foundUser = searchUser(checkedUser.getUserName());
        if (foundUser == null) {
            return 0;
        } else {
            UsersAggregate usersAggregate = new UsersAggregate(users);
            Iterator<User> iterator = usersAggregate.createIterator();
            iterator.resetIndex();

            while (iterator.hasNext()) {
                User temp = iterator.next();
                if (temp.getUserName().equals(checkedUser.getUserName())) {
                    if (temp.getPassword().equals(checkedUser.getPassword())) {
                        return 1;
                    } else return -1;
                }
            }
        }

        return 2;
    }
    public User searchUser(String name) {
        UsersAggregate usersAggregate= new UsersAggregate(users);
        Iterator<User> iterator=usersAggregate.createIterator();
        iterator.resetIndex();

        while (iterator.hasNext()){
            User temp=iterator.next();
            if (temp.getUserName().equals(name)){
                return temp;
            }
        }

        return null;
    }
    public ArrayList<String> searchUserCloseEnough(String name){
        ArrayList<String> potentials=new ArrayList<>();
        UsersAggregate usersAggregate= new UsersAggregate(users);
        Iterator<User> iterator=usersAggregate.createIterator();
        iterator.resetIndex();
        int i=0;
        while (iterator.hasNext()){
            User temp=iterator.next();
            if (temp.getUserName().contains(name)){
                if(temp.isStatus()){
                potentials.add(i,temp.getUserName());
                    i++;
                }



            }
        }

        return potentials;
    }


}
