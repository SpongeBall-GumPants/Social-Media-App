import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

public class ReceiverTest {

    @Test
    public void testLogin() {
        Database db = Database.getDatabase();
        User user = new User("loginUser", "loginPassword");
        db.addUser(user);

        Receiver receiver = new Receiver();
        JFrame frame = new JFrame();

        receiver.login(user, frame);
        assertEquals(1, db.checkUser(user));
    }

    @Test
    public void testRegister() {
        Receiver receiver = new Receiver();
        User newUser = new User("newUser", "newPassword");

        receiver.register(newUser);
        Database db = Database.getDatabase();
        User foundUser = db.searchUser("newUser");
        assertNotNull(foundUser);
        assertEquals("newUser", foundUser.getUserName());
    }

    @Test
    public void testAddFriend() {
        Database db = Database.getDatabase();
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        db.addUser(user1);
        db.addUser(user2);

        Receiver receiver = new Receiver();
        receiver.addFriend(user1, "user2");
        assertNotNull(user1.findFriend("user2"));
        assertNotNull(user2.findFriend("user1"));
    }

    @Test
    public void testRemoveFriend() {
        Database db = Database.getDatabase();
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        db.addUser(user1);
        db.addUser(user2);

        Receiver receiver = new Receiver();
        receiver.addFriend(user1, "user2");
        assertNotNull(user1.findFriend("user2"));

        receiver.removeFriend(user1, "user2");
        assertNull(user1.findFriend("user2"));
    }
}