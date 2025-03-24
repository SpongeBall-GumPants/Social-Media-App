import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class DatabaseTest {//testing database

    @Test
    public void testAddAndSearchUser() {
        Database db = Database.getDatabase();
        User user = new User("testUser", "testPassword");
        db.addUser(user);
        User foundUser = db.searchUser("testUser");
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUserName());
    }

    @Test
    public void testSearchUserCloseEnough() {
        Database db = Database.getDatabase();
        User user1 = new User("johnDoe", "password1");
        User user2 = new User("janeDoe", "password2");
        db.addUser(user1);
        db.addUser(user2);

        ArrayList<String> results = db.searchUserCloseEnough("john");
        assertEquals(1, results.size());
        assertEquals("johnDoe", results.get(0));
    }

    @Test
    public void testCheckUser() {
        Database db = Database.getDatabase();
        User user = new User("checkUser", "checkPassword");
        db.addUser(user);
        assertEquals(1, db.checkUser(user));

        User wrongPasswordUser = new User("checkUser", "wrongPassword");
        assertEquals(-1, db.checkUser(wrongPasswordUser));

        User nonExistentUser = new User("nonExistent", "somePassword");
        assertEquals(0, db.checkUser(nonExistentUser));
    }
}