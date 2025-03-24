import java.util.ArrayList;

public class FamilyAggregate implements Aggregate<Family>{//concrete iterator creator (family iterator)
    private static ArrayList<Family> families;
    public FamilyAggregate(ArrayList<Family> families1){
        families=families1;
    }
    @Override
    public Iterator<Family> createIterator(){
        return new FamilyIterator(families);
    }

}
