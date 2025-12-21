package models;

public class Staff extends User{
    
    public Staff(String name,String roll,String dept)
    {
        this.name = name;
        this.id = roll;
        this.dept = dept;
    }
}
