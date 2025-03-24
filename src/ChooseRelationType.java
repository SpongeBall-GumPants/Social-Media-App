import javax.swing.*;
import java.awt.*;

public class ChooseRelationType {
    private JButton groupsButton;
    private JPanel jPanel;
    private JButton familiesButton;
    public ChooseRelationType(User user){
        JFrame frame = new JFrame("bombabomba.com");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250, 250));
        frame.setResizable(false);
        jPanel.setBounds(0,0,250,250);

        groupsButton.addActionListener(e -> new RelationsMenu(user,0));
        familiesButton.addActionListener(e -> new RelationsMenu(user,1));



        frame.add(jPanel);
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
