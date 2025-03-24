import javax.swing.*;

public class removeFriendCommand extends Command{// concrete command for remmoving friends
    public removeFriendCommand(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute(User user, String string, JFrame frame){
        receiver.removeFriend(user,string);
    }

}
