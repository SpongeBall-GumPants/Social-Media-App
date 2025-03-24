import java.util.ArrayList;
import javax.swing.DefaultListModel;


public class AListToDLMAdapter extends DefaultListModel<String> {//concrete adapter ArrayList->DefaultistModel
    public AListToDLMAdapter(ArrayList<String> arrayList) {
        for (String item : arrayList) {
            this.addElement(item);
        }
    }

}
