import javax.swing.*;

public class logOutCommand extends Command{// concrete command for logging out
    public logOutCommand(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute(User user, String string, JFrame frame){
        receiver.logOut(frame);
    }

    //    public LogInCommand(Receiver receiver) {
    //        super(receiver);
    //    }
    //
    //
    //    @Override
    //    public void execute(User user, String string, JFrame frame) {
    //
    //        receiver.login(user,frame);
    //
    //    }
    //}
}
