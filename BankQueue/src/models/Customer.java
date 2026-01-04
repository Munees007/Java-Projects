package models;

public class Customer {
    public String id;
    public String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Token[" + id + "] Name: " + name;
    }
}
