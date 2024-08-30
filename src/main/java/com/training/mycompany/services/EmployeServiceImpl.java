package com.training.mycompany.services;
import com.training.mycompany.entity.Employe;
import com.training.mycompany.enums.ETAT_EMPLOYE;
import com.training.mycompany.myexceptions.*;
import com.training.mycompany.repository.EmpoloyeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService{


    private final EmpoloyeRepo empoloyeRepo;

    public EmployeServiceImpl(EmpoloyeRepo empoloyeRepo) {
        this.empoloyeRepo = empoloyeRepo;
    }


    @Override
    public Employe addEmploye(Employe employe) {

        employe.setEtat(ETAT_EMPLOYE.ACTIF.toString());
        if (employe.getPrenom().length() < 2){
            throw new IllegalArgumentException(" Le prenom doit contenir au moins 2 caractere !");
        }
        return empoloyeRepo.save(employe);

    }

    @Override
    public List<Employe> listEmploye()  {
        return empoloyeRepo.findAll();
    }

    @Override
    public Employe getOneEmploye(Long id) {

        Optional<Employe> employeSearched = empoloyeRepo.findById(id);

        if (employeSearched.isEmpty()){
            throw new MyNotFoundException(" Aucun employé trouvé avec cet identifiant: "+ id +" Merci de chosir un autre !");
        }


        Employe employeFound = employeSearched.get();

        return employeFound;
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {

        Optional<Employe> employeSearched = empoloyeRepo.findById(id);

        if (employeSearched.isEmpty()){
            throw new MyNotFoundException(" Aucun employé trouvé à mettre à jour avec cet identifiant: "+ id +" Merci de chosir un autre !");
        }

        Employe employeFound = employeSearched.get();
        employeFound.setNom(employe.getNom());
        employeFound.setPrenom(employe.getPrenom());
        employeFound.setEmail(employe.getEmail());
        employeFound.setTel(employe.getTel());
        employeFound.setDateNaiss(employe.getDateNaiss());
        employeFound.setAdresse(employe.getAdresse());
        employeFound.setDateEmbauche(employe.getDateEmbauche());
        employeFound.setEtat(employe.getEtat());


        return empoloyeRepo.save(employeFound);
    }

    @Override
    public void deleteEmploye(Long id) {
        Optional<Employe> employeSearched = empoloyeRepo.findById(id);

        if (employeSearched.isEmpty()){
            throw new MyNotFoundException(" Aucun employé trouvé à supprimer avec cet identifiant: "+ id +" Merci de chosir un autre !");
        }

        Employe employeFound = employeSearched.get();
        employeFound.setEtat(ETAT_EMPLOYE.SUPPRIME.toString());
        empoloyeRepo.save(employeFound);

        throw new MySuccessException(" Operation de suppression reussie !");

    }
}
