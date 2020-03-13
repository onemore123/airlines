package com.example.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    private String phone;
    private String firstName;
    private String lastName;
    private int age;

    public Passenger() {
    }

    public Passenger(
            String firstName,
            String lastName,
            int age,
            String phone
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts =name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getAge() == passenger.getAge() &&
                getId().equals(passenger.getId()) &&
                getPhone().equals(passenger.getPhone()) &&
                getFirstName().equals(passenger.getFirstName()) &&
                getLastName().equals(passenger.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhone(), getFirstName(), getLastName(), getAge());
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
