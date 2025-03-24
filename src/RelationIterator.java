import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RelationIterator implements Iterator<Relation>{//iterate over general relation members
        private int currentIndex = 0;
        private ArrayList<Relation> relations;

       public RelationIterator(ArrayList<Relation> relations) {
          this.relations = relations;
       }

     @Override
     public boolean hasNext() {
         if(relations==null){return false;}
         return currentIndex < relations.size();
     }

      @Override
      public Relation next() {
          if (!hasNext()) {
              throw new NoSuchElementException();
          }
          return relations.get(currentIndex++);
      }
      public void resetIndex(){
          currentIndex=0;
      }
}
