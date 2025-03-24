import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FamilyIterator implements Iterator<Family>{//concrete iterator for going through family members
    private int currentIndex = 0;
    private ArrayList<Family> families;

    public FamilyIterator(ArrayList<Family> families1) {
        this.families = families1;
    }

    @Override
    public boolean hasNext() {
        if(families==null){return false;}
        return currentIndex < families.size();
    }

    @Override
    public Family next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return families.get(currentIndex++);
    }
    public void resetIndex(){
        currentIndex=0;
    }
}