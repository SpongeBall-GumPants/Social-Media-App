import javax.swing.*;

public class postCommand extends Command{// concrete command for creating post
    public postCommand(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void execute(User user, String str, JFrame frame){
        receiver.postSomething(user,str,frame);
    }

}
