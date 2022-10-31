public class BuddyInfo {
    public String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo(){
        name = "N/A";
        address = "N/A";
        phoneNumber = "N/A";
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
        return "Name: " + this.getName() + "    " + "Address: " + this.getAddress() + "    " +  "Phone: " + this.getPhoneNumber();
    }


}
