import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class RelationsMenu {
    private JPanel relationPanel;
    private JList<String> relationsJList;
    private JButton joinButton;
    private JButton leaveButton;
    private JButton connectButton;
    private JButton createButton;
    private JButton backButton;

    public RelationsMenu(User user,int i){
        Database database=Database.getDatabase();
        Receiver receiver = new Receiver();
        ////////////////////////////
        JFrame frame = new JFrame("bombabomba.com");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setResizable(false);
        relationPanel.setBounds(0,0,800,800);
        ArrayList<String> stringArrayList=new ArrayList<>();

        if(i==0){stringArrayList=database.getGroupNames();}
        else if(i==1){stringArrayList=database.getFamilyNames();}
        AListToDLMAdapter adapter=new AListToDLMAdapter(stringArrayList);
        relationsJList.setModel(adapter);
        relationsJList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        Command backCommand=new openMainPageCommand(receiver);
        ButtonInvoker backInvoker=new ButtonInvoker(backCommand,null,frame);
        backButton.addActionListener(e -> {
            backInvoker.setUser(user);
            backInvoker.actionPerformed(e);

        });
        createButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Name : ");
            if(i==0){
                GroupFactory groupFactory=new GroupFactory();
                database.addGroup(groupFactory.create(input));
            }else if(i==1){
                FamilyFactory familyFactory=new FamilyFactory();
                database.addFamily(familyFactory.create(input));
            }
            new RelationsMenu(user,i);
            frame.dispose();
        });

        joinButton.addActionListener(e -> {
            String temp=relationsJList.getSelectedValue();
            if(i==0){
                Group tempG=database.searchGroup(temp);
                if(tempG==null){
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "\t!", JOptionPane.ERROR_MESSAGE);
                }else {
                    if(tempG.checkUser(user)==0){
                        tempG.join(user);
                    }else {JOptionPane.showMessageDialog(null, "Already in Group...", "\t!", JOptionPane.ERROR_MESSAGE);}
                }
            }else if(i==1){
                Family tempG=database.searchFamily(temp);
                if(tempG==null){
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "\t!", JOptionPane.ERROR_MESSAGE);
                }else {
                    if(tempG.checkUser(user)==0){
                        tempG.join(user);
                    }else {JOptionPane.showMessageDialog(null, "Already in Family..", "\t!", JOptionPane.ERROR_MESSAGE);}
                }
            }

        });
        leaveButton.addActionListener(e -> {
            String temp=relationsJList.getSelectedValue();
            if(i==0){
                Group tempG=database.searchGroup(temp);
                if(tempG==null){
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "\t!", JOptionPane.ERROR_MESSAGE);
                }else {
                    if(tempG.checkUser(user)==1){
                        tempG.leave(user);
                    }else {JOptionPane.showMessageDialog(null, "Not in Group...", "\t!", JOptionPane.ERROR_MESSAGE);}
                }
            } else if (i==1) {
                Family tempG=database.searchFamily(temp);
                if(tempG==null){
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "\t!", JOptionPane.ERROR_MESSAGE);
                }else {
                    if(tempG.checkUser(user)==1){
                        tempG.leave(user);
                    }else {JOptionPane.showMessageDialog(null, "Not in Family...", "\t!", JOptionPane.ERROR_MESSAGE);}
                }

            }
        });
        connectButton.addActionListener(e -> {
            String temp=relationsJList.getSelectedValue();
            if(i==0){
                Group tempG=database.searchGroup(temp);
                if(tempG==null) {
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "\t!", JOptionPane.ERROR_MESSAGE);

                }else {
                    tempG.connect(user);
                    frame.dispose();
                }
            } else if (i==1) {
                Family tempG=database.searchFamily(temp);
                if(tempG==null) {
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "\t!", JOptionPane.ERROR_MESSAGE);

                }else {
                    tempG.connect(user);
                    frame.dispose();
                }


            }

        });



        frame.add(relationPanel);
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
