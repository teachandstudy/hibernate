package com.venia.persist.main;

import com.venia.persist.dao.AddressEntity;
import com.venia.persist.dao.ContactsEntity;
import com.venia.persist.dao.EmployeeEntity;
import com.venia.persist.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App2Main {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName("FirstName");
        employee.setLastName("LasettName");

        AddressEntity address = new AddressEntity();
        address.setCity("Moscow");
        address.setStreet("Lenina");

        address.setEmployee(employee);
        employee.setAddressId(1);

        ContactsEntity contacts = new ContactsEntity();
        contacts.setEmail("info@javastudy.ru");
        contacts.setTel("8-800-2000-600");
        employee.addContacts(contacts);

        contacts = new ContactsEntity("mail@javastudy.ru", "8-495-35-35-35");
        employee.addContacts(contacts);

        session.save(employee);
//        session.save(address);

//        List<EmployeeEntity> employeeList = employeeDAO.findAll();
//        for (EmployeeEntity empl : employeeList) {
//            System.out.println("Found entity: " + empl);
//            System.out.println("Address from employee entity: " + empl.getAddress().getAdId());
//            System.out.println("Address from database before transaction complete: " +employeeDAO.findAddressById(empl.getAddressId()) );
//        }

        tx.commit();
        session.close();
    }

}
