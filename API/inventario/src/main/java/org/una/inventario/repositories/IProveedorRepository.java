package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Inventario;
import org.una.inventario.entities.Proveedor;

import java.util.List;
import java.util.Optional;
@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {
    List<Proveedor> findByEstado(String estado);

    List<Proveedor> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);
    // Optional<Proveedor> findById(Long id);

  //  Proveedor save(Proveedor proveedor);
}
