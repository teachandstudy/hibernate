package com.venia.persist.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee", schema = "", catalog = "relationship")
public class EmployeeEntity {
    private int id;
    private String firstName;
    private String lastName;
    private int addressId;

    //OneToMany Example
    private Set<ContactsEntity> contacts = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public Set<ContactsEntity> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<ContactsEntity> contacts) {
        this.contacts = contacts;
    }

    public void addContacts(ContactsEntity contact) {
        contact.setEmployee(this);
        this.contacts.add(contact);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName", nullable = true, insertable = true, updatable = true, length = 200)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = true, insertable = true, updatable = true, length = 200)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "fk_ad_id", nullable = true, insertable = false, updatable = false, columnDefinition = "int default 0")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;
        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return true;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}