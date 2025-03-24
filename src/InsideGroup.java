import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InsideGroup {
    private JList<String> membersList;
    private JPanel panel1;
    private JButton goBack;
    public InsideGroup(Group group,User user){
        JFrame frame = new JFrame("bombabomba.com");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);
        panel1.setBounds(0,0,500,500);

        ArrayList<User> members=group.getMembers();
        ArrayList<String> memberNames=new ArrayList<>();
        UsersAggregate usersAggregate= new UsersAggregate(members);
        Iterator<User> iterator=usersAggregate.createIterator();
        iterator.resetIndex();

        while (iterator.hasNext()){
            User temp=iterator.next();
            memberNames.add(temp.getUserName());
            }
        AListToDLMAdapter adapter=new AListToDLMAdapter(memberNames);
        membersList.setModel(adapter);
        membersList.setEnabled(false);
        goBack.addActionListener(e -> {
            new RelationsMenu(user,0);
            frame.dispose();

        });
        frame.add(panel1);
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }

}

