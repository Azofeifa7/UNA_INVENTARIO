package org.una.inventario.services;

import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.dto.InventarioDTO;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {

    public Optional<InventarioDTO> findById(Long id);
    public Optional<InventarioDTO> create(InventarioDTO inventarioDTO);
    public Optional<InventarioDTO> update(InventarioDTO inventarioDTO, Long id);
    public void delete(Long id);
    public void deleteAll();
    public Optional<List<InventarioDTO>> findAll();
    Optional<List<InventarioDTO>> findbyEstado(String estado);
    public Optional<InventarioDTO> findByResponsable(Long id);
}
