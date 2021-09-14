package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Rol;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRolRepository extends JpaRepository<Rol, Long> {

    //Optional<Rol>findById(Long Id);
    List<Rol> findByEstado(boolean estado);

    //List<Rol> findByFechaCreacion(Date starDate, Date endDate);
    Rol save(Rol rol);

   // void deleteById(Long id);
   // void deleteAll();
}
