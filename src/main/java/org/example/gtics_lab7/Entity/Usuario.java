package org.example.gtics_lab7.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "type", nullable = false)
    private String tipo;

    @Column(name = "authorizedResource", nullable = false)
    private Integer idautorizacion;

    @Column(name = "active", nullable = false)
    private Integer activo;
}
