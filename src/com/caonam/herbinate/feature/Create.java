package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.Instructor;
import com.caonam.herbinate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            //create object
            Instructor tempInstructor = new Instructor("NNN","JIEW1","hia@com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("NNKS", "tennis");

            // associate object
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start transaction
            session.beginTransaction();

            //save object
            System.out.println("Save Instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
