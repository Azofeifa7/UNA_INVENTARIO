package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Valoracion;
@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
}
