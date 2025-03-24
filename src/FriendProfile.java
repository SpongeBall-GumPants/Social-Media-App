import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class FriendProfile {
    private JList<String> frPosts;
    private JPanel frPanel;
    private JButton removeFriendButton;
    private JButton goBackButton;

    public FriendProfile(User ogUser,User user){
        Receiver receiver = new Receiver();
        JFrame frame = new JFrame(user.getUserName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);
        ArrayList<String> Alist =user.seekContents(user);
        Collections.reverse(Alist);
        AListToDLMAdapter ALAdapter = new AListToDLMAdapter(Alist);
        frPosts.setModel(ALAdapter);
        frPosts.setBounds(150,100,200,400);
        frPanel.setBounds(0,0,500,500);
        removeFriendButton.setBounds(350,50,50,25);
        goBackButton.setBounds(10,50,50,50);
        frame.add(frPosts);
        frame.add(frPanel);
        frame.setLayout(null);
        frame.pack();
        frPosts.setVisible(true);
        frPanel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Command mainPageCommand=new openMainPageCommand(receiver);
        ButtonInvoker mainPageInvoker=new ButtonInvoker(mainPageCommand,null,frame);
        Command removeFriendCommand=new removeFriendCommand(receiver);
        ButtonInvoker removeFriendInvoker=new ButtonInvoker(removeFriendCommand,null,null,frame);

        goBackButton.addActionListener(e -> {
            mainPageInvoker.setUser(ogUser);
            mainPageInvoker.actionPerformed(e);
        });
        removeFriendButton.addActionListener(e -> {
           removeFriendInvoker.setUser(ogUser);
           removeFriendInvoker.setString(user.getUserName());
           removeFriendInvoker.actionPerformed(e);


        });

    }
}
