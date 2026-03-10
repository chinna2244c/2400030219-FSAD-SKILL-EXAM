package com.klu.fsad.skill.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ClientDemo {
    public static void main(String[] args) {
        Configuration config= new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session s = sf.openSession();

        Transaction tx1 = s.beginTransaction();
        CustomerAccount c = new CustomerAccount("Raja", "I am a full stack developer", "Unemployeed");
        s.save(c);
       
   

            c.setName("John");
            c.setStatus("Inactive");
            s.update(c);
           
        
        tx1.commit();

        s.close();
        sf.close();
    }
}