import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class AddressBookView extends JFrame {

    private JList<BuddyInfo> buddyList = new JList<>();
    DefaultListModel<BuddyInfo> model = new DefaultListModel<>();
    JPanel pane = new JPanel();

    public AddressBookView() {
        buddyList.setModel(model);
        model.addElement(new BuddyInfo("Jason","123 Alpha Street", "111-222-3333"));
        model.addElement(new BuddyInfo("Marco","456 Beta Street", "111-222-3333"));
        pane.add(new JScrollPane((buddyList)));





    }

}
