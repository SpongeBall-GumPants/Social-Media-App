import javax.swing.*;

public class addFriendCommand extends Command{// concrete command for adding friends
    public addFriendCommand(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute(User user, String string, JFrame frame){
        receiver.addFriend(user,string);
    }

}
