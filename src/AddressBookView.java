import java.util.*;
import javax.swing.*;

public class AddressBookView extends JFrame {

    private JList<BuddyInfo> buddyList = new JList<>();
    DefaultListModel<BuddyInfo> model = new DefaultListModel<>();
    JPanel pane = new JPanel();

    public AddressBookView(AddressBook book) {
        buddyList.setModel(model);
        model.addElement(new BuddyInfo("Jason","123 Alpha Street", "111-222-3333"));
        model.addElement(new BuddyInfo("Marco","456 Beta Street", "111-222-3333"));
        for (BuddyInfo b : book.getBuddyList()) {
            model.addElement(b);
        }


        pane.add(new JScrollPane((buddyList)));
    }

    public DefaultListModel getModel() {
        return model;
    }

    public JList getBuddyList() {
        return buddyList;
    }

}
