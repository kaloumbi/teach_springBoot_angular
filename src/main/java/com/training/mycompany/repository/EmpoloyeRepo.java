package com.training.mycompany.repository;

import com.training.mycompany.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpoloyeRepo extends JpaRepository<Employe, Long> {

}
