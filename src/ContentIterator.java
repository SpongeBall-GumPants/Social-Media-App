import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ContentIterator implements Iterator<String> {//concrete iterator for going through posts from a user
    private int currentIndex = 0;
    private ArrayList<Post> posts;

    public ContentIterator(ArrayList<Post> post1) {
        this.posts = post1;
    }

    @Override
    public boolean hasNext() {
        if(posts==null){return false;}
        return currentIndex < posts.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return posts.get(currentIndex++).getContent();
    }
    public void resetIndex(){
        currentIndex=0;
    }

}
