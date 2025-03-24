import javax.swing.*;
import java.awt.*;


public class LoginPage extends JFrame{
    private JTextField userNameText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JPanel panel1;
    private JButton registerButton;
    private JLabel imageLog;
    private JFrame frame;
    private Receiver receiver;

    public LoginPage(){
        Receiver receiver= new Receiver();


        frame=new JFrame("bombabomba.com");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,300));
        frame.setResizable(false);
        ///////
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Command loginCommand = new LogInCommand(receiver);
        Command registerCommand = new RegisterCommand(receiver);

        // Create Invoker objects
        ButtonInvoker loginInvoker = new ButtonInvoker(loginCommand, null,frame);
        ButtonInvoker registerInvoker = new ButtonInvoker(registerCommand, null,frame);

        // Set action listeners
        loginButton.addActionListener(e -> {
            User user = new User(userNameText.getText(), new String(passwordText.getPassword()));
            loginInvoker.setUser(user);
            loginInvoker.actionPerformed(e);

        });

        registerButton.addActionListener(e -> {
            User user = new User(userNameText.getText(), new String(passwordText.getPassword()));
            registerInvoker.setUser(user);
            registerInvoker.actionPerformed(e);

        });

    }


    private void createUIComponents() {
        imageLog=new JLabel(new ImageIcon("bomba.png"));

    }
}
