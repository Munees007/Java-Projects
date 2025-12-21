package models;

public class Student extends User {
    public Student(String name,String roll,String dept)
    {
        this.name = name;
        this.id = roll;
        this.dept = dept;
    }
}
