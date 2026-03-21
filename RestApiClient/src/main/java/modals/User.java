package modals;

public class User {
    public int id;
    public String name;
    public String email;
    public String phone;
    public String website;
    public Address address;

    public static class Address {
        public String city;
    }
}