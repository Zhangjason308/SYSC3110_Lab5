import java.util.StringTokenizer;

public class BuddyInfo {
    public String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo(){
        name = "N/A";
        address = "N/A";
        phoneNumber = "N/A";
    }

    public BuddyInfo(String name) {
        this.name = name;
    }
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean equals(BuddyInfo b) {
        return this == b;
    }

    public String toString() {
        return this.getName() +"#" +this.getAddress() + "#"+ this.getPhoneNumber()+"\n";
    }

    public static BuddyInfo importBuddyInfo(String buddyName) { // String should be Name#Address#Number
        String[] parse = buddyName.split("#");
        return new BuddyInfo(parse[0],parse[1],parse[2]);
    }


}
