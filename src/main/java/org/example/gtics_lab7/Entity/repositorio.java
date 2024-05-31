package org.example.gtics_lab7.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resources")
@Getter
@Setter
public class repositorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resourcesId", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String nombre;
}
