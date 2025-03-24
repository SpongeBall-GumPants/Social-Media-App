import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainPage extends JFrame{
    private JList<String> posts;
    private JPanel panel1;
    private JList<String> friendsList;
    private JTextField postField;
    private JButton profileOpnButton;
    private JButton postButton;
    private JRadioButton setStatusButton;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton logOutButton;
    private JButton relationsButton;
    private JLabel image;
    private JPanel icPanel;

    public MainPage(User user) {
        Receiver receiver = new Receiver();
        JFrame frame = new JFrame("bombabomba.com");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1020, 900));
        frame.setResizable(false);


        // user'ın içeriğini adapter aracılığıyla posts JList'ine ekle
        ObsToDLMAdapter ObsAdapter = new ObsToDLMAdapter(user.getFriends());
        ArrayList<String> Alist =user.seekContents(user);
        Collections.reverse(Alist);
        AListToDLMAdapter ALAdapter = new AListToDLMAdapter(Alist);

        posts.setModel(ALAdapter);

        posts.setEnabled(false);

        friendsList.setModel(ObsAdapter);
        friendsList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        /////////////////friend List yeri
        friendsList.setBounds(700,400,300,600);
        profileOpnButton.setBounds(700,300,300,100);
        setStatusButton.setBounds(720,200,85,50);
        //////////////////////////post atma yeri
        posts.setBounds(0,250,700,550);
        postField.setBounds(0,200,600,50);
        postButton.setBounds(600,200,100,50);
        relationsButton.setBounds(0,700,700,100);




        panel1.setBounds(0,0,1020,900);

        Command findPeople=new findFriendCommand(receiver);
        ButtonInvoker findInvoker=new ButtonInvoker(findPeople,null,null,frame);
        Command postIt = new postCommand(receiver);
        ButtonInvoker postInvoker = new ButtonInvoker(postIt,null,null,frame);
        Command openFriend =new OpenFriendCommand(receiver);
        ButtonInvoker openFInvoker=new ButtonInvoker(openFriend,null,null,frame);
        Command logOutCommand=new logOutCommand(receiver);
        ButtonInvoker logOutInvoker=new ButtonInvoker(logOutCommand,null,frame);

        logOutButton.addActionListener(logOutInvoker);
        /////////////arkadaşa gitme:
        profileOpnButton.addActionListener(e -> {
            String friend =friendsList.getSelectedValue();

            if(friendsList.getSelectedIndex()!=-1){
                openFInvoker.setUser(user);
                openFInvoker.setString(friend);
                openFInvoker.actionPerformed(e);
            }
        });
        relationsButton.addActionListener(e -> {
            new ChooseRelationType(user);
            frame.dispose();
        });
        ////////////////////priv hesap tuşu
        setStatusButton.addActionListener(e -> {
            boolean isSelected = setStatusButton.isSelected();
            user.setStatus(isSelected);
            if(isSelected){
                JOptionPane.showMessageDialog(null, "Account set to Private", "\t!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Account set to Public", "\t!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ////////////////post yapma:
        postButton.addActionListener(e -> {
            String post =postField.getText();
            if(!post.equals("")){
                postInvoker.setUser(user);
                postInvoker.setString(post);
                postInvoker.actionPerformed(e);
            }else{
                JOptionPane.showMessageDialog(null, "Write Something", "\t!", JOptionPane.ERROR_MESSAGE);
            }
        });

        ////////////////////insan aratma:

        searchButton.addActionListener(e -> {
            String name=searchTextField.getText();
            if(!name.equals("")){
                findInvoker.setString(name);
                findInvoker.setUser(user);
                findInvoker.actionPerformed(e);

            }else{
                JOptionPane.showMessageDialog(null, "Write Something", "\t!", JOptionPane.ERROR_MESSAGE);
            }


        });

        ////////////////////
        frame.add(relationsButton);
        frame.add(setStatusButton);
        frame.add(profileOpnButton);
        frame.add(postButton);
        frame.add(postField);
        frame.add(friendsList);
        frame.add(posts);
        frame.add(panel1);
        ///////////////////////
        frame.setLayout(null);
        frame.pack();
        posts.setVisible(true);
        friendsList.setVisible(true);
        panel1.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        image=new JLabel(new ImageIcon("bomba.png"));
        // TODO: place custom component creation code here
    }
}






