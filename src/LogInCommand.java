import javax.swing.*;

public class LogInCommand extends Command{// concrete command for logging in
    public LogInCommand(Receiver receiver) {
        super(receiver);
    }


    @Override
    public void execute(User user, String string, JFrame frame) {

        receiver.login(user,frame);

    }
}