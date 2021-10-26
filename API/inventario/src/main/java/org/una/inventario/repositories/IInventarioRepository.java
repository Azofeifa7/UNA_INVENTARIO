package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.entities.Inventario;

import java.util.List;
import java.util.Optional;

public interface IInventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<InventarioDTO> findByResponsable(Long id);
    public List<Inventario> findByEstado(String estado);

}
