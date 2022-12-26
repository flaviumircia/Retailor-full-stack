package com.flaviumircia.pibd_app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    Long id_order;
    String item_title;
    String item_description;
    int quantity;
    double unit_price;
    @Transient
    double total;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    Set<Association> associationSet;
//
//    @ManyToMany(mappedBy = "orders")
//    private List<Client> clients=new ArrayList<>();
    public Orders(){

    }
    public Orders(Long id_order, String item_title, String item_description, int quantity, double unit_price) {
        this.id_order = id_order;
        this.item_title = item_title;
        this.item_description = item_description;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Orders(String item_title, String item_description, int quantity, double unit_price) {
        this.item_title = item_title;
        this.item_description = item_description;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id) {
        this.id_order = id;
    }

    public Set<Association> getAssociationSet() {
        return associationSet;
    }

    public void setAssociationSet(Set<Association> associationSet) {
        this.associationSet = associationSet;
    }

//    public List<Client> getClients() {
//        return clients;
//    }
//
//    public void setClients(List<Client> clients) {
//        this.clients = clients;
//    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getTotal() {
        return this.quantity*this.unit_price;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id_order=" + id_order +
                ", item_title='" + item_title + '\'' +
                ", item_description='" + item_description + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", total=" + total +
                '}';
    }
}
