package com.flaviumircia.pibd_app.pojos;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.models.Orders;

public class AssociationPojo {
    Long id;
    Client client;
    Orders order;
    String payment;

    public AssociationPojo(Long id, Client client, Orders order, String payment) {
        this.id = id;
        this.client = client;
        this.order = order;
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

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "{" +"\n"+
                "id:'" + id + "\',\n"+
                "client_id:'"+client.getId()+ "\',\n"+
                "client_name:'" + client.getName() +"\',\n"+
                "client_address:'" + client.getAddress()+"\',\n"+
                "client_email:'" + client.getEmail()+"\',\n"+
                "order_id:'"+order.getId_order()+"\',\n"+
                "order_name:'" + order.getItem_title() +"\',\n"+
                "order_quantity:'" + order.getQuantity()+"\',\n"+
                "order_total_price:'" + order.getTotal() +"\',\n"+
                "payment:'" + payment + '\'' + "\n"+
                '}'+"\n";
    }
}
