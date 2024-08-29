package com.training.mycompany.repository;

import com.training.mycompany.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepo extends JpaRepository<Entreprise, Long> {

}
