package org.example.gtics_lab7.Repository;

import org.example.gtics_lab7.Entity.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioRepository extends JpaRepository<Repositorio,Integer> {
}
