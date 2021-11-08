package org.una.inventario.services;

import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.dto.ProveedorDTO;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {

    public Optional<ProveedorDTO> findById(Long id);
    public Optional<ProveedorDTO> create(ProveedorDTO proveedorDTO);
    public Optional<ProveedorDTO> update(ProveedorDTO proveedorDTO, Long id);
    public void delete(Long id);
    public void deleteAll();
    public Optional<List<ProveedorDTO>> findAll();
    Optional<List<ProveedorDTO>> findbyEstado(String estado);
    public Optional<List<ProveedorDTO>> findByNombreAproximateIgnoreCase(String nombreCompleto);
}
