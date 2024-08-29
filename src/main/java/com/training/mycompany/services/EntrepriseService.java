package com.training.mycompany.services;

import com.training.mycompany.entity.Entreprise;

import java.util.List;

public interface EntrepriseService {

    Entreprise addEntreprise(Entreprise entreprise);

    List<Entreprise> listEntreprises();

    Entreprise detailEntreprise(Long id);

    Entreprise updateEntreprise(Long id, Entreprise entreprise);

    void deleteEntreprise(Long id);
}
