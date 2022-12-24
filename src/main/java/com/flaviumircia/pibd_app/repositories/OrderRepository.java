package com.flaviumircia.pibd_app.repositories;

import com.flaviumircia.pibd_app.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT o from Orders o where o.item_title=?1")
    Optional<Orders> findOrderByItemTitle(String item_title);
}
