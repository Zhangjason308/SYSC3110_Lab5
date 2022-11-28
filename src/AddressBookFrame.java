import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AddressBookFrame extends JFrame  {

    private JButton[][] buttons;
    private JMenuBar menuBar;
    private JMenu addressMenu; // for AddressBook and BuddyInfo specific operations
    private JMenu buddyMenu;
    private JMenuItem showBook; //Each operation would be a menu item
    private JMenuItem newBook;
    private JMenuItem addBuddy;
    private JMenuItem removeBuddy;

    private JMenuItem export;

    private JMenuItem imported;

    public AddressBookFrame() {
        super("Address Book");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        AddressBook model = new AddressBook();
        AddressBookView view = new AddressBookView(model);
        //AddressBookController controller = new AddressBookController(model);
        menuBar = new JMenuBar();
        addressMenu = new JMenu("Address");
        buddyMenu = new JMenu("Buddy");
        newBook = new JMenuItem("New Book");
        addBuddy = new JMenuItem("Add Buddy");
        removeBuddy = new JMenuItem("Remove Buddy");
        export = new JMenuItem("Export");
        imported = new JMenuItem("Import");
        menuBar.add(addressMenu);
        menuBar.add(buddyMenu);
        addressMenu.add(newBook);
        buddyMenu.add(addBuddy);
        addressMenu.add(removeBuddy);
        addressMenu.add(export);
        addressMenu.add(imported);
        this.setVisible(true);
        this.setJMenuBar(menuBar);
        this.add(view.pane);

        imported.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = JOptionPane.showInputDialog("Enter file name: ");
                AddressBook newBook = model.importAddressBook(filename);
                for (BuddyInfo bd: newBook.getBuddyList()) {
                    view.model.addElement(bd);
                }

            }
        });
        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = JOptionPane.showInputDialog("Enter file name: ");
                model.save(filename);
            }
        });

        addBuddy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input_name = JOptionPane.showInputDialog("Enter name: ");
                String input_address = JOptionPane.showInputDialog("Enter address: ");
                String input_number = JOptionPane.showInputDialog("Enter phone number: ");
                view.model.addElement(new BuddyInfo(input_name, input_address, input_number)); //change model private

            }
        });

        newBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.model.clear();
            }
        });

        removeBuddy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getModel().removeElement(view.getBuddyList().getSelectedValue());
            }

                /*
                view.getBuddyList().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        java.util.List selectedItems = view.getBuddyList().getSelectedValuesList();
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            for (Object o : selectedItems) {
                                view.getModel().removeElement(o);
                                break;
                            }
                        }
                    }
                });
            }

             */
        });

    }
    public static void main(String[] args) {
        new AddressBookFrame();
    }
}
