import javax.swing.*;
import java.util.ArrayList;
import java.util.*;

public class AddressBook extends DefaultListModel {

    private ArrayList<BuddyInfo> myBuddies;
    private List<AddressBookView> views;

    public AddressBook() {
        myBuddies = new ArrayList<>();
        views = new ArrayList<>();
    }
    public void addBuddy(BuddyInfo aBuddy) {
        if (aBuddy!=null) {
            myBuddies.add(aBuddy);
        }
    }
    public BuddyInfo removeBuddy(int index) {
        if (index >= 0 && index < myBuddies.size()) {
            return myBuddies.remove(index);
        }
        return null;
    }

    public ArrayList<BuddyInfo> getBuddyList() {
        return myBuddies;
    }

    public void randomFunction(int index) {
        System.out.println("Part 3 Question 4");
    }

    @Override
    public String toString() {
        String output = "Address Book\n";
        for(BuddyInfo b: myBuddies) {
            output += b.toString();
        }
        return output;
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Tom","Carleton", "613");
        AddressBook book = new AddressBook();
        book.addBuddy(buddy);
        System.out.println(book.toString());
    }

    public void addAddressBookView(AddressBookView v) {
        views.add(v);
    }
}
