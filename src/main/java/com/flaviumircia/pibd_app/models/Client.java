package com.flaviumircia.pibd_app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table
public class Client {

    @Id
    @SequenceGenerator(
            name="client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    Long id;
     String name;
     String address;
     String email;
     String city;
     String state;
     String zipcode;
     String phone_no;

     @OneToMany(mappedBy = "client")
     @JsonIgnore
     Set<Association> associationSet;

     public Client(Long id, String name, String address, String email, String city, String state, String zipcode, String phone_no) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone_no = phone_no;
    }

    public Client(String name, String address, String email, String city, String state, String zipcode, String phone_no) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone_no = phone_no;
    }

    public Client() {

    }

    public void addAssociation(Association association){
         associationSet.add(association);
    }
    public Set<Association> getAssociationSet() {
        return associationSet;
    }

    public void setAssociationSet(Set<Association> associationSet) {
        this.associationSet = associationSet;
    }

    //
//    /**
//     * Removes order from association table
//     * @param order
//     */
//    public void removeOrder(Orders order) {
//        orders.remove(order);
//        order.getClients().remove(this);
//    }
//
//    /**
//     * adds order to assciation table
//     * @param order
//     */
//    public void addOrder(Orders order){
//         orders.add(order);
//         order.getClients().add(this);
//    }
//    public List<Orders> getAllOrders(){
//        return orders;
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone_no='" + phone_no + '\'' +
                '}';
    }
}
