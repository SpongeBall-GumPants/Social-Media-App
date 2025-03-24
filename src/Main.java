public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Receiver receiver = new Receiver();
        Post post1=new Post("aaaaaaaaaaaaaaaaaaaaaaa");
        Post post2=new Post("aaaaaaaaaaaaaaaaaaaaaaa");
        Post post3=new Post("aaaaaaaaaaaaaaaaaaaaaaa");
        Wall wall =new Wall();
        wall.addPost(post1);
        wall.addPost(post2);
        wall.addPost(post3);
        Wall wall2=new Wall();
        wall2.addPost(post1);
        Wall wall3=new Wall();
        wall3.addPost(post2);
        Wall wall4 = new Wall();
        wall4.addPost(post3);
        Database db =Database.getDatabase();
        User u1=new User("a","a");
        User u2=new User("allah","b");
        User u3=new User("allame","c");
        User u4=new User("arap hüsnü","d");
        User u5=new User("arrr","e");
        User u6=new User("f","f");
        u1.addObserver(u2);
        u1.addObserver(u3);
        u1.addObserver(u5);
        u1.setWall(wall);
        u2.setWall(wall2);
        u3.setWall(wall3);
        u4.setWall(wall4);
        u5.setStatus(false);
        db.addUser(u1);
        db.addUser(u2);
        db.addUser(u3);
        db.addUser(u4);
        db.addUser(u5);
        new LoginPage();
        System.out.println(u1.getWall().getPosts().toString());

    }
}
