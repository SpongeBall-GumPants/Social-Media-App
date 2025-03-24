import javax.swing.*;

public class openMainPageCommand extends Command{// concrete command for going back to main page
    public openMainPageCommand(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute(User user, String string, JFrame frame){
        receiver.openMainPage(user,frame);
    }
}
