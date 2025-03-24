
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class UserTest {

    @Test
    public void testAddFriend() {
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        user1.addFriend(user2);
        assertNotNull(user1.findFriend("user2"));
    }

    @Test
    public void testPostMessage() {
        User user = new User("user", "password");
        user.postMessage("Hello, world!");
        assertEquals(1, user.getWall().getPosts().size());
        assertEquals("Hello, world!", user.getWall().getPosts().get(0).getContent());
    }

    @Test
    public void testSeekContents() {
        User user = new User("user", "password");
        user.postMessage("Hello, world!");
        user.postMessage("Second post");

        ArrayList<String> contents = user.seekContents(user);
        assertEquals(2, contents.size());
        assertEquals("Hello, world!", contents.get(0));
        assertEquals("Second post", contents.get(1));
    }
}