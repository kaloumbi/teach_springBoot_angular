package com.training.mycompany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "tel")
    private String tel;

    @Column(name = "dateNaiss")
    private Date dateNaiss;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "dateEmbauche")
    private Date dateEmbauche;

    @Column(name = "etat")
    private String etat;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "entreprise_id", referencedColumnName = "id")
    private Entreprise entreprise;
}
