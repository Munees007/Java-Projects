package com.example.persistence.main;

import org.hibernate.Session;

import com.example.persistence.entity.Student;
import com.example.persistence.util.HibernateUtil;

public class TestHibernate {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Student s = new Student();
            s.setName("Munees");
            s.setDepartment("BCA");

            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();

            System.out.println("✅ Data inserted successfully bro 🔥");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}