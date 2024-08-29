package com.training.mycompany.services;
import com.training.mycompany.entity.Employe;
import com.training.mycompany.enums.ETAT_EMPLOYE;
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
        return empoloyeRepo.save(employe);
    }

    @Override
    public List<Employe> listEmploye() {

        return empoloyeRepo.findAll();
    }

    @Override
    public Employe getOneEmploye(Long id) {

        Optional<Employe> employeSearched = empoloyeRepo.findById(id);

        if (employeSearched.isEmpty()){
            return null;
        }

        Employe employeFound = employeSearched.get();

        return employeFound;
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {

        Optional<Employe> employeSearched = empoloyeRepo.findById(id);

        if (employeSearched.isEmpty()){
            return null;
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
            throw new IllegalArgumentException(" Aucun employe trouvé");
        }

        Employe employeFound = employeSearched.get();
        employeFound.setEtat(ETAT_EMPLOYE.SUPPRIME.toString());
        empoloyeRepo.save(employeFound);

    }
}
