package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Exepcion;
import org.una.inventario.entities.Rol;

import java.util.List;
@Repository
public interface IExepcionRepository extends JpaRepository<Exepcion, Long> {
    List<Exepcion> findByUsuarioId(Long id);

    List<Exepcion> findByEstado(boolean term);
}
