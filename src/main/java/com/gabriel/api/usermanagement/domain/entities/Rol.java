package com.gabriel.api.usermanagement.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "rol")
    private Set<UserRol> assignations;

    public Rol(){

    }

    public Rol(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
