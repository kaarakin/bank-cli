public class Customer {
    private int id;
    private String fullname;

    public static int count = 0;

    public Customer(String fullname) {
        this.id = count;
        this.fullname = fullname;
        count++;
    }

    public int getId() {
        return this.id;
    }

    public String getFullname() {
        return this.fullname;
    }
}