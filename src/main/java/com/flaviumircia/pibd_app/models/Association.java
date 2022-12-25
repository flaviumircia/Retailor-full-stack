package com.flaviumircia.pibd_app.models;

import jakarta.persistence.*;

@Entity
public class Association {
    @Id
    @SequenceGenerator(
            name="association_sequence",
            sequenceName = "association_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "association_sequence"
    )
    Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_client")
    Client client;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_order")
    Orders orders;

    String payment;

    public Association() {

    }
    public Association(Long id, Client client, Orders orders, String payment) {
        this.id = id;
        this.client = client;
        this.orders = orders;
        this.payment = payment;
    }

    public Association(Client client, Orders orders, String payment) {
        this.client = client;
        this.orders = orders;
        this.payment = payment;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", client=" + client.getName() +
                ", orders=" + orders.getItem_title() +
                ", payment='" + payment + '\'' +
                '}';
    }
}
