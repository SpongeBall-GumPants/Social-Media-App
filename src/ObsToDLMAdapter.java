import javax.swing.*;
import java.util.ArrayList;

public class ObsToDLMAdapter extends DefaultListModel<String> {//concrete adapter Observer names->DefaultistModel
    public ObsToDLMAdapter(ArrayList<Observer> friendsList) {
        for (Observer item : friendsList) {
            this.addElement(((User) item).getUserName());

        }
    }
}
