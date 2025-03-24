import java.util.ArrayList;
import java.util.List;

public class Wall {//walls  can be expanded, we currently only have posts
    ArrayList<Post> posts;
    public Wall() {
        posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

}
