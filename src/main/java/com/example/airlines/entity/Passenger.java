package com.example.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Passenger extends User {
    @Id
    @GeneratedValue
    private Long id;
    private String phone;

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return id.equals(passenger.id) &&
                phone.equals(passenger.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, phone);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
