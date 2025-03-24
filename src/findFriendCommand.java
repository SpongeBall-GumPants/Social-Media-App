import javax.swing.*;

public class findFriendCommand extends Command{// concrete command for finding friends
    public findFriendCommand(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void execute(User user, String str, JFrame frame){
        receiver.findFriend(user,str,frame);
    }
}
