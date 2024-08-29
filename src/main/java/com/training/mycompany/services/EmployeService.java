package com.training.mycompany.services;

import com.training.mycompany.entity.Employe;

import java.util.List;

public interface EmployeService {

    Employe addEmploye(Employe employe);

    List<Employe> listEmploye();

    Employe getOneEmploye(Long id);

    Employe updateEmploye(Long id, Employe employe);

    void deleteEmploye(Long id);
}
