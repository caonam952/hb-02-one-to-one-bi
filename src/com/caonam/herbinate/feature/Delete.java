package com.caonam.herbinate.feature;

import com.caonam.herbinate.entity.Instructor;
import com.caonam.herbinate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            //start transaction
            session.beginTransaction();

            //get instructor by id
            int theId = 1;

            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Found instructor on id = " + theId + ":" + tempInstructor);

            //delete
            if (tempInstructor != null){

                System.out.println("deleting instructor: " + tempInstructor);
                session.delete(tempInstructor);
            }else System.out.println("Not found instructor on id = " + theId);


            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
