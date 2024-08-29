package com.training.mycompany.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomEntreprise")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "email")
    private String email;

    @Column(name = "tel")
    private String tel;

    @Column(name = "dateCreation")
    private Date dateCreation;

    @Column(name = "secteurActivite")
    private String secteurActivity;

    @Column(name = "etat")
    private String etat;

    @OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Employe> employeList = new ArrayList<>();

}
