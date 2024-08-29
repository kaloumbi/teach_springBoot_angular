package com.training.mycompany.controller;

import com.training.mycompany.entity.Entreprise;
import com.training.mycompany.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    @PostMapping("entreprise/added")
    public ResponseEntity<Entreprise> addEntreprise(@RequestBody Entreprise entreprise){

        Entreprise entrepriseAdded = entrepriseService.addEntreprise(entreprise);

        return ResponseEntity.ok(entrepriseAdded);
    }

    @GetMapping("entreprises/list")
    public List<Entreprise> entrepriseList(){

        return entrepriseService.listEntreprises();
    }

    @GetMapping("entreprise/{id}/detail")
    public Entreprise detailEntreprise(@PathVariable Long id){

        return entrepriseService.detailEntreprise(id);
    }


    @PutMapping("entreprise/{id}/updated")
    public Entreprise updateEntreprise(@PathVariable Long id, @RequestBody Entreprise entreprise){

        return entrepriseService.updateEntreprise(id, entreprise);
    }


    @DeleteMapping("entreprise/{id}/deleted")
    public String deleteEntreprise(@PathVariable Long id){

        entrepriseService.deleteEntreprise(id);

        return "Entreprise supprimee avec succès ! ";
    }




}
