package com.training.mycompany.services;

import com.training.mycompany.entity.Employe;
import com.training.mycompany.entity.Entreprise;
import com.training.mycompany.enums.ETAT_ENTREPRISE;
import com.training.mycompany.repository.EntrepriseRepo;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{

    @Autowired
    private EntrepriseRepo entrepriseRepo;

    @Override
    public Entreprise addEntreprise(Entreprise entreprise) {

        entreprise.setEtat(ETAT_ENTREPRISE.ACTIF.toString());
        return entrepriseRepo.save(entreprise);
    }

    @Override
    public List<Entreprise> listEntreprises() {
        List<Entreprise> entrepriseList = entrepriseRepo.findAll();
        return entrepriseRepo.findAll();
    }

    //affichages des entreprises dont leurs etat est actif

    /*@Override
    public List<Entreprise> listEntreprises() {
        List<Entreprise> entrepriseList = entrepriseRepo.findAll();

        // Filtrer les entreprises actives
        List<Entreprise> entreprisesActives = entrepriseList.stream()
                .filter(entreprise -> entreprise.getEtat().equals(ETAT_ENTREPRISE.ACTIF.toString()))
                .collect(Collectors.toList());

        return entreprisesActives;
    }*/


    @Override
    public Entreprise detailEntreprise(Long id) {

        Optional<Entreprise> entrepriseSearche = entrepriseRepo.findById(id);

        if (entrepriseSearche.isEmpty()){
            return null;
        }

        return entrepriseSearche.get();
    }

    @Override
    public Entreprise updateEntreprise(Long id, Entreprise entreprise) {

        Optional<Entreprise> entrepriseSearched = entrepriseRepo.findById(id);

        if (entrepriseSearched.isEmpty()){
            return null;
        }
        Entreprise entrepriseFound = entrepriseSearched.get();
        entrepriseFound.setNom(entreprise.getNom());
        entrepriseFound.setAdresse(entreprise.getAdresse());
        entrepriseFound.setEmail(entreprise.getEmail());
        entrepriseFound.setTel(entreprise.getTel());
        entrepriseFound.setDateCreation(entreprise.getDateCreation());
        entrepriseFound.setSecteurActivity(entreprise.getSecteurActivity());
        entrepriseFound.setEtat(entreprise.getEtat());

        return entrepriseRepo.save(entrepriseFound);

    }

    @Override
    public void deleteEntreprise(Long id) {

        Optional<Entreprise> entrepriseSearched = entrepriseRepo.findById(id);

        if (entrepriseSearched.isEmpty()){
            throw new IllegalArgumentException("Aucune entreprise à supprimer ! ");
        }

        Entreprise entrepriseFound = entrepriseSearched.get();
        entrepriseFound.setEtat(ETAT_ENTREPRISE.SUPPRIME.toString());
        entrepriseRepo.save(entrepriseFound);

    }
}
