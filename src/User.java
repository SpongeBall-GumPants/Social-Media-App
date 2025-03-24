import java.util.ArrayList;


class User implements Subject,Observer {//user is both subject and observer
    /////////////////fields:
    private boolean status;
    private String userName;
    private String password;

    private ArrayList<Observer> friends;
    private Wall wall;
    /////////////////////////constructor,getters & setters:
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.friends = new ArrayList<>();
        this.wall = new Wall();
        this.setStatus(true);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setFriends(ArrayList<Observer> friends) {
        this.friends = friends;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public boolean isStatus() {
        return status;
    }

    public Wall getWall() {
        return wall;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Observer> getFriends() {
        return friends;
    }

    public  void addFriend(User friend){
        this.friends.add(friend);
    }
    ///////////////////////////////////Observer Design Pattern Implementation:
    @Override
    public void addObserver(Observer observer) {
        friends.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        friends.remove(observer);
    }

    @Override
    public void notifyObservers(Post post) {
        for (Observer friend : friends) {
            friend.update(post);
        }
    }
    public Observer findFriend(String string){
        for(Observer friend : friends){
            if(((User) friend).getUserName().equals(string))return friend;
        }
        return null;
    }

    public void postMessage(String content) {
        Post post = new Post(content);
        this.update(post);
        notifyObservers(post);
    }

    @Override
    public void update(Post post) {
        this.wall.addPost(post);
    }
    //////////////////////////////// Content Iterator(Concrete Iterator) Implementation
    public ArrayList<String> seekContents(User user){
        ArrayList<String> postStrings= new ArrayList<>();
        int i=0;
        ArrayList<Post>posts=user.wall.getPosts();
        ContentAggregate contentAggregate=new ContentAggregate(posts);
        Iterator<String> iterator=contentAggregate.createIterator();
        while (iterator.hasNext()){
            postStrings.add(i,iterator.next());
            i++;
        }
        return postStrings;
    }////////////////////this ArrayList is also used in an Adapter...



}


