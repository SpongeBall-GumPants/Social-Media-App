import java.util.ArrayList;

public class RelationAggregate implements Aggregate<Relation>{//create iterator
    private static ArrayList<Relation> relations;
    public RelationAggregate(ArrayList<Relation> relation){
        relations=relation;
    }
    @Override
    public Iterator<Relation> createIterator(){
        return new RelationIterator(relations);
    }

}
