package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Activo;

import java.util.List;
import java.util.Optional;

public interface IActivoRepository extends JpaRepository<Activo, Long> {

    List<Activo> findByEstado(String term);

    Optional<Activo> findByNombre(String nombre);
}
