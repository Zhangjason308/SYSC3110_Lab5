import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @org.junit.jupiter.api.Test
    void ExportingthenImporting() {
        AddressBook model = new AddressBook();
        BuddyInfo bd1 = new BuddyInfo("Jason","Carleton", "613-981-2838");
        BuddyInfo bd2 = new BuddyInfo("Babak","Kingston", "888-988-8888");
       BuddyInfo bd3 = new BuddyInfo("Geoff","Ottawa", "777-777-7777");
        model.addBuddy(bd1);
        model.addBuddy(bd2);
        model.addBuddy(bd3);
        System.out.println(model.toString());
        model.save("AddressBookTestsss.txt");
        AddressBook importedAddressBook = model.importAddressBook("AddressBookTestsss.txt");
        assertEquals(model.toString(),importedAddressBook.toString());

    }
}