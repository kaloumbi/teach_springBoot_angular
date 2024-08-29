package com.training.mycompany.controller;

import com.training.mycompany.entity.Employe;
import com.training.mycompany.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("employe/add")
    public ResponseEntity<Employe> addEmploye(@RequestBody Employe employe){

        Employe employeAdded = employeService.addEmploye(employe);

        return new ResponseEntity<>(employeAdded, HttpStatus.OK);
    }

    @GetMapping("employe/list")
    public ResponseEntity<List<Employe>> listEmploye(){

        List<Employe> employeList = employeService.listEmploye();
        return new ResponseEntity<>(employeList, HttpStatus.OK);
    }

    @GetMapping("employe/{id}/detail")
    public ResponseEntity<Employe> detailEmploye(@PathVariable Long id){

        Employe employDetail = employeService.getOneEmploye(id);

        return new ResponseEntity<>(employDetail, HttpStatus.OK);
    }

    @PutMapping("employe/{id}/updated")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe){

        Employe employUpdated = employeService.updateEmploye(id, employe);

        return new ResponseEntity<>(employUpdated, HttpStatus.OK);

    }

    @DeleteMapping("employe/{id}/deleted")
    public ResponseEntity<String> deleteEmploye(@PathVariable Long id){

        employeService.deleteEmploye(id);

        return new ResponseEntity<>("Employé supprimé avec succes !", HttpStatus.OK);
    }
}
