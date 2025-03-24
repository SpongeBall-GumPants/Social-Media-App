import javax.swing.*;

public class RegisterCommand extends Command{// concrete command for registering
    public RegisterCommand(Receiver receiver) {
        super(receiver);
    }
    @Override
    void execute(User user, String string, JFrame frame) {
        receiver.register(user);
    }
}
