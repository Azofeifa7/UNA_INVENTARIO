package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Activo;


import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface IActivoRepository extends JpaRepository<Activo, Long> {

    List<Activo> findByEstado(String term);

    Optional<Activo> findByNombre(String nombre);

//    @Query(value = "SELECT u FROM Activo u LEFT JOIN u.marca e WHERE " +
//            "  e.id=:idMarcaProve AND u.fechaCreacion >= :startDate AND u.fechaCreacion <= :endDate ORDER BY u.fechaCreacion DESC")
//    public List<Activo> findByActivosxMarcaDescBetweenFechas(@Param("idMarcaProve")Long idMarcaProve,
//                                                             @Param("startDate")Date startDate,
//                                                             @Param("endDate")Date endDate);


    @Query(value = "SELECT u FROM Activo u LEFT JOIN u.proveedor e WHERE e.id=:id AND u.fechaCreacion >= :fechaInicio AND " +
            "u.fechaCreacion <= :fechaFinal ORDER BY u.id DESC ")
    public  List<Activo> findByProveedorIdAndStartDate(@Param("id") Long id, @Param("fechaInicio") Date inicio, @Param("fechaFinal") Date fin);
}
