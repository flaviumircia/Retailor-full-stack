package com.flaviumircia.pibd_app.repositories;

import com.flaviumircia.pibd_app.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//    Will transform in something like:
//    SELECT * FROM clients WHERE email=?;
    @Query("SELECT c FROM Client c where c.email=?1")
    Optional<Client> findClientByEmail(String email);

}
