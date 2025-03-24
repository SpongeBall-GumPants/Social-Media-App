import java.util.ArrayList;

public class ContentAggregate implements Aggregate<String>{//concrete iterator creator
    private static ArrayList<Post> posts;

    public ContentAggregate(ArrayList<Post> posts1) {
        posts=posts1;
    }

    @Override
    public Iterator<String> createIterator() {
        return new ContentIterator(posts);
    }
}
