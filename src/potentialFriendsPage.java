import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class potentialFriendsPage {
    private JList<String> potentialsList;
    private JPanel potentialsPanel;
    private JButton addFriendButton;
    private JButton goBackButton;

    public potentialFriendsPage(ArrayList<String> potentials,User ogUser,JFrame ogFrame){
        Receiver receiver=new Receiver();
        JFrame frame = new JFrame("Search Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);

        ////////////////////

        AListToDLMAdapter ALAdapter=new AListToDLMAdapter(potentials);
        potentialsList.setModel(ALAdapter);
        potentialsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        potentialsList.setBounds(125,25,250,300);
        potentialsPanel.setBounds(0,0,500,500);
        addFriendButton.setBounds(375,500,20,50);
        goBackButton.setBounds(0,500,20,50);
        /////////////
        frame.add(potentialsList);
        frame.add(potentialsPanel);
        addFriendButton.setVisible(true);
        goBackButton.setVisible(true);
        potentialsList.setVisible(true);
        potentialsPanel.setVisible(true);

        Command mainPageCommand=new openMainPageCommand(receiver);
        ButtonInvoker mainPageInvoker=new ButtonInvoker(mainPageCommand,null,frame);
        Command addFriendCommand=new addFriendCommand(receiver);
         ButtonInvoker addFriendInvoker=new ButtonInvoker(addFriendCommand,null,null,frame);

       goBackButton.addActionListener(e -> {
           mainPageInvoker.setUser(ogUser);
           mainPageInvoker.actionPerformed(e);
       });
       addFriendButton.addActionListener(e -> {
           String username=potentialsList.getSelectedValue();
           addFriendInvoker.setUser(ogUser);
           addFriendInvoker.setString(username);
           addFriendInvoker.actionPerformed(e);
       });
        ///////////////////////
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
