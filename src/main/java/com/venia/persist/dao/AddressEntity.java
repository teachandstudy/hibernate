package com.venia.persist.dao;

import javax.persistence.*;


@Entity
@Table(name = "address", schema = "", catalog = "relationship")
public class AddressEntity {
    private int adId;
    private String street;
    private String city;

    private EmployeeEntity employee;

    @OneToOne
    @JoinColumn(name = "fk_contact_id", referencedColumnName = "id")
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id", nullable = false, insertable = true, updatable = true)
    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    @Basic
    @Column(name = "street", nullable = true, insertable = true, updatable = true, length = 200)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city", nullable = true, insertable = true, updatable = true, length = 200)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (adId != that.adId) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adId;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "adId=" + adId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
