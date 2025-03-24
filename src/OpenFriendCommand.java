import javax.swing.*;

public class OpenFriendCommand extends Command{// concrete command for opening friend page
    public OpenFriendCommand(Receiver receiver){
        super(receiver);

    }
    @Override
    public void execute(User user, String string, JFrame frame){
        receiver.openFriend(user,string,frame);
    }

}
