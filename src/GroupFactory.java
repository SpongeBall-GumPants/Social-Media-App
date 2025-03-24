public class GroupFactory implements Factory{//concrete factory for group creation
    @Override
    public Group create(String groupName){
        return new Group(groupName);
    }
}
