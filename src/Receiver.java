import javax.swing.*;
import java.util.ArrayList;

public class Receiver {//receiver has implementations that every command utilizes,each method also has a command
    private final Database db;

    public Receiver() {
        this.db=Database.getDatabase();
    }

    private int checkResult;




    public void login(User user,JFrame frame){
        checkResult=db.checkUser(user);
        User temp;
        switch (checkResult) {
            case 1:
                temp=db.searchUser(user.getUserName());
                new MainPage(temp);
                frame.setVisible(false);

                break;
            case 0:
                // Error message: user doesn't exist...
                JOptionPane.showMessageDialog(null, "User doesn't exist!", "Login Error", JOptionPane.ERROR_MESSAGE);
                break;
            case -1:
                // Error message: wrong password...
                JOptionPane.showMessageDialog(null, "Wrong password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                // Handle any other cases if necessary
                break;
        }}

    public void register(User user){
        checkResult=db.checkUser(user);
        if (checkResult == 0) {
            Wall wall =new Wall();
            user.setWall(wall);
            db.addUser(user);
            JOptionPane.showMessageDialog(null, "Yeni Hesap Oluşturuldu!\nLütfen Giriş Yapınız", "bombabomba.com", JOptionPane.INFORMATION_MESSAGE);

            //TODO şifre ve hesap isminde string kontrolü
        } else {// Error message: user already exists...
            JOptionPane.showMessageDialog(null, "User already exists!", "Registration Error", JOptionPane.ERROR_MESSAGE);
        }



    }
    public void openFriend(User user,String friendName,JFrame frame){


            new FriendProfile(user,db.searchUser(friendName));
            frame.setVisible(false);

    }
    public  void postSomething(User user,String post,JFrame frame){
            user.postMessage(post);
            frame.dispose();
            new MainPage(user);
            JOptionPane.showMessageDialog(null, "Post Oluşturuldu.", "bombabomba.com", JOptionPane.INFORMATION_MESSAGE);


    }
    public void findFriend(User user,String friend,JFrame frame){
        ArrayList<String> potentials=db.searchUserCloseEnough(friend);
        potentials.remove(user.getUserName());
        new potentialFriendsPage(potentials,user,frame);
        frame.dispose();



    }
    public void openMainPage(User user,JFrame frame){
        new MainPage(user);
        frame.dispose();
    }
    public void removeFriend(User ogUser,String userName){
        User user=db.searchUser(userName);
        if(user==null){
            JOptionPane.showMessageDialog(null, "An error has occured..", "bombabomba.com", JOptionPane.ERROR_MESSAGE);

        }else {
            ogUser.removeObserver(user);
            JOptionPane.showMessageDialog(null, "Removed Friend", "\t!", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public void addFriend(User ogUser,String userName){
        User user=db.searchUser(userName);
        if(user==null){
            JOptionPane.showMessageDialog(null, "An error has occured..", "bombabomba.com", JOptionPane.ERROR_MESSAGE);

        }else{
            if(ogUser.findFriend(userName)==null){
            ogUser.addObserver(user);
            user.addObserver(ogUser);
            JOptionPane.showMessageDialog(null, "Added Friend", "\t!", JOptionPane.INFORMATION_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "Person is already in Friends List", "!", JOptionPane.ERROR_MESSAGE);

        }

    }
    public void logOut(JFrame frame){
        new LoginPage();
        frame.dispose();


    }



}
