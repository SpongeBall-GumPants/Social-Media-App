public interface Subject {//interface for observer design pattern subject
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Post post);
}
