import javax.swing.*;

public abstract class Command {//Command abstract class for execute()
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    abstract void execute(User user,String string,JFrame frame);

}

