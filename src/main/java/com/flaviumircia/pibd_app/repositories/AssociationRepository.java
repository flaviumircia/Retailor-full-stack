package com.flaviumircia.pibd_app.repositories;

import com.flaviumircia.pibd_app.models.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
