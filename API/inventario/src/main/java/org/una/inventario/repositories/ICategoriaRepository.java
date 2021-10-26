package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Categoria;
import org.una.inventario.entities.Inventario;

import java.util.List;
import java.util.Optional;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByEstado(String term);

    Optional<Categoria> findByNombre(String nombre);
}
