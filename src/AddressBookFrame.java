import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookFrame extends JFrame  {

    private JButton[][] buttons;
    private JMenuBar menuBar;
    private JMenu addressMenu; // for AddressBook and BuddyInfo specific operations
    private JMenu buddyMenu;
    private JMenuItem showBook; //Each operation would be a menu item
    private JMenuItem newBook;
    private JMenuItem addBuddy;
    private JMenuItem removeBuddy;
    public AddressBookFrame() {
        super("Address Book");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        AddressBook model = new AddressBook();
        AddressBookView view = new AddressBookView();
        AddressBookController controller = new AddressBookController(model);
        menuBar = new JMenuBar();
        addressMenu = new JMenu("Address");
        buddyMenu = new JMenu("Buddy");
        newBook = new JMenuItem("New Book");
        addBuddy = new JMenuItem("Add Buddy");
        removeBuddy = new JMenuItem("Remove Buddy");
        showBook = new JMenuItem("Show Book");
        menuBar.add(addressMenu);
        menuBar.add(buddyMenu);
        addressMenu.add(newBook);
        buddyMenu.add(addBuddy);
        addressMenu.add(removeBuddy);
        addressMenu.add(showBook);
        this.setVisible(true);
        this.setJMenuBar(menuBar);
        this.add(view.pane);

        addBuddy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input_name = JOptionPane.showInputDialog("Enter name: ");
                String input_address = JOptionPane.showInputDialog("Enter address: ");
                String input_number = JOptionPane.showInputDialog("Enter phone number: ");
                model.addBuddy(new BuddyInfo(input_name, input_address,input_number));
            }
        });

        newBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               model.getBuddyList().clear();
            }
        });

        removeBuddy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input_name = JOptionPane.showInputDialog("Enter buddy number (0-n): ");
                System.out.println(model.removeBuddy(Integer.parseInt(input_name)));
            }
        });

        showBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(model);
            }
        });


    }


    public static void main(String[] args) {
        new AddressBookFrame();
    }
}
