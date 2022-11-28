import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
//package addr;


public class AddressBook extends DefaultListModel implements Serializable {

    private ArrayList<BuddyInfo> myBuddies;
    private List<AddressBookView> views;

    public AddressBook() {
        myBuddies = new ArrayList<>();
        views = new ArrayList<>();
    }


    public void addBuddy(BuddyInfo aBuddy) {
        if (aBuddy != null) {
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

    public void save(String fileName) {
        ArrayList<String> bdArray = new ArrayList<>();
        byte[] bytes;

        for (BuddyInfo bd : getBuddyList()) {
            bdArray.add(bd.toString());
        }

        try (FileOutputStream file = new FileOutputStream(fileName)) {
            for (String bdString : bdArray) {
                bytes = bdString.getBytes();
                file.write(bytes);
            }
        //file.flush();
            file.close();
        }

    catch(IOException ex)

    {
        System.out.println("IOException is caught");
    }
    }

    public AddressBook importAddressBook(String fileName) {
        AddressBook imported = new AddressBook();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while(line != null) {
                imported.addBuddy(BuddyInfo.importBuddyInfo(line));
                line = br.readLine();
            }
            br.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return imported;
    }

    @Override
    public String toString() {
        String output = "";
        for(BuddyInfo b: getBuddyList()) {
            output += b.toString() +"\n";
        }
        return output;
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Tom","Carleton", "613");

        AddressBook book = new AddressBook();
        book.addBuddy(buddy);
        //book.save("bdtext.txt");
        System.out.println(book.toString());
    }

    public void addAddressBookView(AddressBookView v) {
        views.add(v);
    }
}
