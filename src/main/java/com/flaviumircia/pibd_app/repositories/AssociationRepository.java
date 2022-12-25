package com.flaviumircia.pibd_app.repositories;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.pojos.AssociationPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
    @Query("select new com.flaviumircia.pibd_app.pojos.AssociationPojo(a.id, a.client, a.orders, a.payment)" +
            " from Association a inner join Orders o  on o.id_order=a.id inner join Client c on o.id_order=c.id")
    List<AssociationPojo[]> findAllSumarized();
}
