import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Invoker sınıfı
public class ButtonInvoker extends JButton implements ActionListener {//Command Design pattern invoker
    private Command command;
    private User user;
    private String string;
    private JFrame frame;

    public ButtonInvoker(Command command,User user,JFrame frame) {
        this.user=user;
        this.command = command;
        addActionListener(this);
        this.frame=frame;
    }
    public ButtonInvoker(Command command,User user, String string,JFrame frame){
        this.user=user;
        this.command=command;
        addActionListener(this);
        this.string=string;
        this.frame=frame;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setString(String string){
        this.string=string;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execute(user,string,frame);
    }
}
