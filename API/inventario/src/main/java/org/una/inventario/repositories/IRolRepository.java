package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Rol;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

    //Optional<Rol>findById(Long Id);
    List<Rol> findByEstado(boolean estado);

    //List<Rol> findByFechaCreacion(Date starDate, Date endDate);


   // void deleteById(Long id);
   // void deleteAll();
}
